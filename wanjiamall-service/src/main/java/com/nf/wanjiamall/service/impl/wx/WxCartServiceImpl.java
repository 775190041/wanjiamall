package com.nf.wanjiamall.service.impl.wx;
import com.nf.wanjiamall.dao.*;
import com.nf.wanjiamall.entity.*;
import com.nf.wanjiamall.service.wx.WxCartService;
import com.nf.wanjiamall.utils.JacksonUtil;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * 购车车 实现类
 */
@Service
@Slf4j
public class WxCartServiceImpl implements WxCartService {

    @Autowired(required = false)
    private CartDao cartDao;
    @Autowired(required = false)
    private GoodsDao goodsDao;
    @Autowired(required = false)
    private GoodsProductDao goodsProductDao;
    @Autowired(required = false)
    private AddressDao addressDao;
    @Autowired(required = false)
    private CouponDao couponDao;
    @Autowired(required = false)
    private CouponUserDao couponUserDao;
    @Autowired(required = false)
    private SystemDao systemDao;

    /**
     * 根据用户Id查询购物车信息与计算选中商品的金额
     * @param userId
     * @return
     */
    @Override
    public Object getUserIdQueryCartAll(Integer userId) {
        if (userId != null){
            //得到用户购物车所以商品信息
            List<CartEntity> list = cartDao.getUserIdQueryCartAll(userId);
            //存储所有商品信息
            List<CartEntity> cartEntityList = new ArrayList<>();
            // 如果系统检查商品已删除或已下架，则系统自动删除。
            // 更好的效果应该是告知用户商品失效，允许用户点击按钮来清除失效商品。
            for (CartEntity cart : list){
                //查询该商品的信息
                GoodsEntity goods = goodsDao.getGoodById(cart.getGoodsSn());
                //判断该商品是否存在 以及 该商品是否上下架
                if (goods == null && !goods.getIsOnSale()){
                    //都为真进行商品失效处理。
                    cartDao.deleteById(cart.getId());
                    log.info("系统自动删除失效购物车商品 productId=" + cart.getUserId());
                } else {
                    //存储所有商品信息
                    cartEntityList.add(cart);
                }
            }
            //商品个数
            Integer goodsCount = 0;
            //商品金额
            BigDecimal goodsAmount = new BigDecimal(0.00);
            //商品选中个数
            Integer checkedGoodsCount = 0;
            //选中商品金额
            BigDecimal checkedGoodsAmount = new BigDecimal(0.00);
            //遍历所有该用户购物车商品所有信息
            for (CartEntity cart : cartEntityList) {
                //获取商品个数
                goodsCount += cart.getNumber();
                // 商品金额 (成倍叠加 意思是有2个商品 价格是10元 所以 2 * 10  = 20)
                goodsAmount = goodsAmount.add(cart.getPrice().multiply(new BigDecimal(cart.getNumber())));
                if (cart.getChecked() == 0 ) {
                    //选中个数
                    checkedGoodsCount += cart.getNumber();
                    //选中商品金额
                    checkedGoodsAmount = checkedGoodsAmount.add(cart.getPrice().multiply(new BigDecimal(cart.getNumber())));
                }
            }
            //存储商品的金额
            Map<String, Object> cartTotal = new HashMap<>();
            cartTotal.put("goodsCount", goodsCount);
            cartTotal.put("goodsAmount", goodsAmount);
            cartTotal.put("checkedGoodsCount", checkedGoodsCount);
            cartTotal.put("checkedGoodsAmount", checkedGoodsAmount);
            //存储商品的数据
            Map<String, Object> result = new HashMap<>();
            result.put("cartList", cartEntityList);
            result.put("cartTotal", cartTotal);
            return ResponseUtil.ok(result);
        }else{
            return ResponseUtil.fail(501,"请登录!");
        }
    }


    /**
     * 加入商品到购物车
     * 如果已经存在购物车货品，则增加数量；
     * 否则添加新的购物车货品项。
     * @param userId 用户ID
     * @param cartEntity   购物车商品信息， { goodsId: xxx, productId: xxx, number: xxx }
     * @return 加入购物车操作结果
     */
    @Override
    public Object insertCart(Integer userId,CartEntity cartEntity) {
        if (userId == null){
            return ResponseUtil.fail(501,"请登录");
        }
        if (cartEntity == null) {
            return ResponseUtil.badArgument();
        }
        //获取数据
        Integer productId = cartEntity.getProductId();
        Integer number = cartEntity.getNumber();
        Integer goodsId = Integer.valueOf(cartEntity.getGoodsSn());
        //判断参数是否为空
        if (!ObjectUtils.allNotNull(productId, number , goodsId)) {
            return ResponseUtil.badArgument();
        }
        if(number <= 0){
            return ResponseUtil.badArgument();
        }
        //判断商品是否可以购买
        GoodsEntity goods = goodsDao.getGoodById(goodsId.toString());
        if (goods == null || !goods.getIsOnSale()) {
            return ResponseUtil.fail(710, "商品已下架");
        }
        //查询是否有该商品的货。
        GoodsProductEntity product = goodsProductDao.getProductByGoodsId(productId);
        CartEntity existCart = cartDao.getExist(userId,goodsId,productId);
        //判断购物车中是否存在此规格商品
        if (existCart == null ){
            //不存在就加入购物车实体
            //取得规格的信息,判断规格库存
            if (product == null || number > product.getNumber()) {
                return ResponseUtil.fail(711, "库存不足");
            }
            cartEntity.setId(null);
            cartEntity.setGoodsSn(goods.getGoodsSn());
            cartEntity.setGoodsName((goods.getName()));
            if(StringUtils.isEmpty(product.getUrl())){
                cartEntity.setPicUrl(goods.getPicUrl());
            } else{
                cartEntity.setPicUrl(product.getUrl());
            }
            cartEntity.setPrice(new BigDecimal(product.getPrice()));
            cartEntity.setSpecification( Arrays.toString(product.getSpecifications()));
            System.out.println("cartEntity = " + cartEntity.getSpecification());
            cartEntity.setUserId(userId);
            cartEntity.setChecked(0);
            cartDao.insertCart(cartEntity);
        }else {
            //存在就增加商品数量
            //取得规格的信息,判断规格库存
            int num = existCart.getNumber() + number;
            if (num > product.getNumber()) {
                return ResponseUtil.fail(711, "库存不足");
            }
            existCart.setNumber(num);
            if (cartDao.updateById(existCart) == 0) {
                return ResponseUtil.updateDataFailed();
            }
        }
        //购物车商品货品数量
        return goodsCount(userId);
    }

    /**
     * 购物车商品货品数量
     * 如果用户没有登录，则返回空数据。
     * @param userId 用户ID
     * @return 购物车商品货品数量
     */
    @GetMapping("/goodsCount")
    public Object goodsCount(Integer userId) {
        if (userId == null) {
            return ResponseUtil.ok(0);
        }
        int goodsCount = 0;
        List<CartEntity> cartList = cartDao.getUserIdQueryCartAll(userId);
        for (CartEntity cart : cartList) {
            goodsCount += cart.getNumber();
        }
        return ResponseUtil.ok(goodsCount);
    }

    /**
     * 立即购买
     * 和add方法的区别在于：
     * 1. 如果购物车内已经存在购物车货品，前者的逻辑是数量添加，这里的逻辑是数量覆盖
     * 2. 添加成功以后，前者的逻辑是返回当前购物车商品数量，这里的逻辑是返回对应购物车项的ID
     * @param userId 用户ID
     * @param cartEntity   购物车商品信息， { goodsId: xxx, productId: xxx, number: xxx }
     * @return 立即购买操作结果
     */
    @Override
    public Object buyImmediately(Integer userId, CartEntity cartEntity){
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        if (cartEntity == null) {
            return ResponseUtil.badArgument();
        }
        Integer productId = cartEntity.getProductId();
        Integer number = cartEntity.getNumber();
        Integer goodsId = Integer.valueOf(cartEntity.getGoodsSn());
        if (!ObjectUtils.allNotNull(productId, number, goodsId)) {
            return ResponseUtil.badArgument();
        }
        if(number <= 0){
            return ResponseUtil.badArgument();
        }
        //判断商品是否可以购买
        GoodsEntity goods = goodsDao.getGoodById(goodsId.toString());
        if (goods == null || !goods.getIsOnSale()) {
            return ResponseUtil.fail(711, "商品已下架");
        }
        GoodsProductEntity product = goodsProductDao.getProductByGoodsId(productId);
        //判断购物车中是否存在此规格商品
        CartEntity existCart = cartDao.getExist(userId,goodsId, productId);
        //判断购物车中是否存在此规格商品
        if (existCart == null ){
            //不存在就加入购物车实体
            //取得规格的信息,判断规格库存
            if (product == null || number > product.getNumber()) {
                return ResponseUtil.fail(711, "库存不足");
            }
            cartEntity.setId(null);
            cartEntity.setGoodsSn(goods.getGoodsSn());
            cartEntity.setGoodsName((goods.getName()));
            if(StringUtils.isEmpty(product.getUrl())){
                cartEntity.setPicUrl(goods.getPicUrl());
            } else{
                cartEntity.setPicUrl(product.getUrl());
            }
            cartEntity.setPrice(new BigDecimal(product.getPrice()));
            cartEntity.setSpecification(Arrays.toString(product.getSpecifications()));
            cartEntity.setUserId(userId);
            cartEntity.setChecked(0);
            cartDao.insertCart(cartEntity);
        }else {
            //存在就增加商品数量
            //取得规格的信息,判断规格库存
            int num = existCart.getNumber() + number;
            if (num > product.getNumber()) {
                return ResponseUtil.fail(711, "库存不足");
            }
            existCart.setNumber(num);
            if (cartDao.updateById(existCart) == 0) {
                return ResponseUtil.updateDataFailed();
            }
        }
        return ResponseUtil.ok(existCart != null ? existCart.getId() : cartEntity.getId());
    }

    /**
     * 修改购物车商品货品数量
     * @param userId 用户ID
     * @param cartEntity   购物车商品信息， { id: xxx, goodsSn: xxx, productId: xxx, number: xxx }
     * @return 修改结果
     */
    @Override
    public Object updateByGoodsAndProductNumber(Integer userId, CartEntity cartEntity) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        if (cartEntity == null) {
            return ResponseUtil.badArgument();
        }
        Integer id = cartEntity.getId();
        Integer goodsId = Integer.valueOf(cartEntity.getGoodsSn());
        Integer productId = cartEntity.getProductId();
        Integer number = cartEntity.getNumber();
        if (!ObjectUtils.allNotNull(id,goodsId,productId,number)) {
            return ResponseUtil.badArgument();
        }
        if(number <= 0){
            return ResponseUtil.badArgument();
        }
        //判断是否存在该订单
        // 如果不存在，直接返回错误
        CartEntity existCart = cartDao.getUserIdAndGoodsIduQueryCart(userId,goodsId);
        if (existCart == null) {
            return ResponseUtil.badArgumentValue();
        }
        // 判断goodsId和productId是否与当前cart里的值一致
        if (!existCart.getGoodsSn().equals(goodsId.toString())) {
            return ResponseUtil.badArgumentValue();
        }
        if (!existCart.getProductId().equals(productId)) {
            return ResponseUtil.badArgumentValue();
        }

        //判断商品是否可以购买
        GoodsEntity goods = goodsDao.getGoodById(goodsId.toString());
        if (goods == null || !goods.getIsOnSale()) {
            return ResponseUtil.fail(711, "商品已下架");
        }

        //取得规格的信息,判断规格库存
        GoodsProductEntity product = goodsProductDao.getProductByGoodsId(productId);
        if (product == null || product.getNumber() < number) {
            return ResponseUtil.fail(711, "库存不足");
        }
        existCart.setNumber(number);
        if (cartDao.updateById(existCart) == 0) {
            return ResponseUtil.updateDataFailed();
        }
        return ResponseUtil.ok();
    }

    /**
     * 购物车商品货品勾选状态
     * 如果原来没有勾选，则设置勾选状态；如果商品已经勾选，则设置非勾选状态。
     * @param userId 用户ID
     * @param body   购物车商品信息， { productIds: xxx, isChecked: 1/0 }
     * @return 购物车信息
     */
     @Override
     public Object checked(Integer userId, String body) {
         if (userId == null) {
             return ResponseUtil.unlogin();
         }
         if (body == null) {
             return ResponseUtil.badArgument();
         }
         Integer checkValue = JacksonUtil.parseInteger(body, "isChecked");
         if (checkValue == null) {
             return ResponseUtil.badArgument();
         }
         List<Integer> cartIds = JacksonUtil.parseIntegerList(body, "cartIds");
         if (cartIds == null) {
             return ResponseUtil.badArgument();
         }
         Boolean isChecked = (checkValue == 1);
         if (isChecked == true){
             checkValue = 1;
         } else {
             checkValue = 0;
         }
         cartDao.updateCheck(cartIds,checkValue);
         return getUserIdQueryCartAll(userId);
     }

    /**
     * 购物车商品删除
     * @param userId 用户ID
     * @param body   购物车商品信息， { productIds: xxx }
     * @return 购物车信息
     * 成功则
     * {errno: 0,
     * errmsg: '成功',
     * data: xxx}
     * 失败则 { errno: 505, errmsg: XXX }
     */
    @Override
    public Object delete(Integer userId, String body) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        if (body == null) {
            return ResponseUtil.badArgument();
        }
        List<Integer> cartIds = JacksonUtil.parseIntegerList(body, "cartIds");
        if (cartIds == null || cartIds.size() == 0) {
            return ResponseUtil.badArgument();
        }
        cartDao.delete(cartIds, userId);
        return getUserIdQueryCartAll(userId);
    }


    /**
     * 购物车确认下单
     * @param userId    用户ID
     * @param cartId    购物车商品ID：
     *                  如果购物车商品ID是空，则下单当前用户所有购物车商品；
     *                  如果购物车商品ID非空，则只下单当前购物车商品。
     * @param addressId 收货地址ID：
     *                  如果收货地址ID是空，则查询当前用户的默认地址。
     * @param couponId  优惠券ID：
     *                  如果优惠券ID是空，则自动选择合适的优惠券。
     * @return 购物车操作结果
     */
    @Override
    public Object cartOrder(Integer userId, Integer cartId, Integer addressId, Integer couponId, Integer userCouponId) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        //所有收货地址
        List<AddressEntity> addressList = addressDao.getUserIdAddressAll(userId);
        // 收货地址
        AddressEntity checkedAddress = null;
        //等于空或者等于0
        if (addressId == null || addressId.equals(0)) {
            //查找是否有默认地址
            checkedAddress = addressDao.getAddressDefault(userId);
            // 如果仍然没有地址，则是没有收货地址
            // 返回一个空的地址id=0，这样前端则会提醒添加地址
            if (checkedAddress == null) {
                checkedAddress = new AddressEntity();
                checkedAddress.setId(0);
                addressId = 0;
            } else {
                //有就得到id
                addressId = checkedAddress.getId();
            }
        } else {
            //id不等于空时查询该用户的地址
            checkedAddress = addressDao.getAddressIdAndUserIdQuery(userId, addressId);
            // 如果null, 则报错
            if (checkedAddress == null) {
                return ResponseUtil.badArgumentValue();
            }
        }
        // 选中的商品
        List<CartEntity> checkedGoodsList = null;
        //购物车id等于空时或者等于0时
        if (cartId == null || cartId.equals(0)) {
            //查询购物车所有勾选商品信息
            checkedGoodsList = cartDao.getUserIdQueryCartCheckedGoodsAll(userId);
        } else {
            //购物车id不等于空时 查询购物车购物的id
            CartEntity cart = cartDao.getUserIdAndGoodsIduQueryCart(userId, cartId);
            if (cart == null) {
                return ResponseUtil.badArgumentValue();
            }
            checkedGoodsList = new ArrayList<>(1);
            //此商品添加到集合中
            checkedGoodsList.add(cart);
        }

        //选中的商品的价格
        BigDecimal checkedGoodsPrice = new BigDecimal(0.00);
        for (CartEntity cart : checkedGoodsList) {
            //商品价格 * 商品数量
            checkedGoodsPrice = checkedGoodsPrice.add(cart.getPrice().multiply(new BigDecimal(cart.getNumber())));
        }

        // 计算优惠券可用情况
        BigDecimal tmpCouponPrice = new BigDecimal(0.00);
        Integer tmpCouponId = 0;
        Integer tmpUserCouponId = 0;
        int tmpCouponLength = 0;
        //查询该用户所有优惠券
        List<CouponUserEntity> couponUserList = couponUserDao.getUserIdCouponUserAll(userId);
        //可用优惠卷信息
        CouponEntity availableCoupon = null;
        //得到用户自选得优惠券信息
        CouponEntity optionalCoupon = null;
        //遍历优惠券信息
        for(CouponUserEntity couponUser : couponUserList){
            //得到该用户的优惠券id
            tmpUserCouponId = couponUser.getId();
            //查看优惠券是否可用
            availableCoupon = checkCoupon(userId, couponUser.getCouponId(), tmpUserCouponId);
            if(availableCoupon == null){
                continue;
            }
            //coupon如果不为空 则优惠券可用数量+
            tmpCouponLength ++;
            //如果指定的availableCoupon.getDiscount()数小于tmpCouponPrice 参数返回 -1。
            if(tmpCouponPrice.compareTo(availableCoupon.getDiscount()) == -1){
                //availableCoupon.getMin() < checkedGoodsPrice, 返回-1()
                if (availableCoupon.getMin().compareTo(checkedGoodsPrice) == -1 ){
                    //得到优惠券金额
                    tmpCouponPrice = availableCoupon.getDiscount();
                    //得到优惠券id
                    tmpCouponId = availableCoupon.getId();
                }
            }
        }
        // 获取优惠券减免金额，优惠券可用数量
        int availableCouponLength = tmpCouponLength;
        BigDecimal couponPrice = new BigDecimal(0);
        // 这里存在三种情况
        // 1. 用户不想使用优惠券，则不处理
        // 2. 用户想自动使用优惠券，则选择合适优惠券
        // 3. 用户已选择优惠券，则测试优惠券是否合适
        if (couponId == null || couponId.equals(-1)){
            couponId = -1;
            userCouponId = -1;
        }
        else if (couponId.equals(0)) {
            //得到优惠卷可用金额
            couponPrice = tmpCouponPrice;
            //得到优惠券id
            couponId = tmpCouponId;
            //得到该用户的优惠券id
            userCouponId = tmpUserCouponId;
        }else {
            //测试优惠卷是否合适
            optionalCoupon = checkCoupon(userId, couponId, userCouponId);
            // 用户选择的优惠券有问题，则选择合适优惠券，否则使用用户选择的优惠券
            if(optionalCoupon == null){
                couponPrice = tmpCouponPrice;
                couponId = tmpCouponId;
                userCouponId = tmpUserCouponId;
            }
            else {
                //优惠卷没有问题就得到优惠券金额
                couponPrice = optionalCoupon.getDiscount();
            }
        }
        // 根据订单商品总价计算运费，满88则免运费，否则8元；
        SystemEntity system =  systemDao.getFreight("wanjia_express_freight_min");
       //得到运费价格
        BigDecimal freightPrice =  new BigDecimal(system.getKeyValue());
        //商品总价比运费价格大
        if (checkedGoodsPrice.compareTo(freightPrice) == 1){
            //则免运费
            freightPrice = new BigDecimal(0.0);
        }else{
            freightPrice = new BigDecimal(8);
        }
        // 订单费用
        BigDecimal orderTotalPrice = checkedGoodsPrice.add(freightPrice).subtract(couponPrice).max(new BigDecimal(0.00));
        Map<String, Object> data = new HashMap<>();
        //收货地址Id
        data.put("addressId", addressId);
        //优惠券Id
        data.put("couponId", couponId);
        //用户优惠卷Id
        data.put("userCouponId", userCouponId);
        //购物车Id
        data.put("cartId", cartId);
        //优惠券可用金额
        data.put("couponPrice", couponPrice);
        //收货地址信息
        data.put("checkedAddress", checkedAddress);
        //所有收货地址
        data.put("addressList",addressList);
        //用户所有优惠券信息
        data.put("couponUserList",couponUserList);
        //用户可用优惠券可用
        data.put("availableCoupon",availableCoupon);
        //用户自选优惠券信息
        data.put("optionalCoupon",optionalCoupon);
        //用户优惠券可用数量
        data.put("availableCouponLength", availableCouponLength);
        //选中得商品价格
        data.put("goodsTotalPrice", checkedGoodsPrice);
        //运费价格
        data.put("freightPrice", freightPrice);
        //订单费用
        data.put("orderTotalPrice", orderTotalPrice);
        //选中的商品（展现在下面）
        data.put("checkedGoodsList", checkedGoodsList);
        return ResponseUtil.ok(data);
    }

    /**
     * 检测优惠券是否适合
     * @param userId
     * @param couponId
     * @return
     */
    public CouponEntity checkCoupon(Integer userId, Integer couponId, Integer userCouponId) {
        //查看优惠券是否存在
        CouponEntity coupon = couponDao.getCouponById(couponId);
        if (coupon == null) {
            return null;
        }
        //查看用户优惠卷是否存在
       CouponUserEntity couponUser = couponUserDao.getUserCouponIdOrUesrId(userCouponId,userId);
        if (couponUser == null) {
            return null;
        }
        //判断优惠券与用户优惠是否相同
        if (!couponId.equals(couponUser.getCouponId())) {
            return null;
        }
        // 检查是否超期
        Integer timeType = coupon.getTimeType();
        Integer days = coupon.getDays();
        LocalDateTime date = LocalDateTime.now();
        if (timeType.equals(1)) {
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zdt = date.atZone(zoneId);
            Date dates = Date.from(zdt.toInstant());
            if (dates.before(coupon.getStartTime()) && dates.after((coupon.getAddTime()))) {
                return coupon;
            }
        }
        //有效时限制是0
        else if(timeType.equals(0)) {
            //把基于时间的有效天数加到时间中
            LocalDateTime now = couponUser.getAddTime().toLocalDateTime().plusDays(days);
            System.out.println("now = " + now);
            if (date.isBefore(now)) {
                return coupon;
            }
        }
        else {
            return null;
        }

        // 检测商品是否符合
        Integer goodType = coupon.getGoodsType();
        if (!goodType.equals(0)){
            return null;
        }
        // 检测订单状态
        Integer status = coupon.getStatus();
        if (!status.equals(0)) {
            return null;
        }
        return coupon;
    }
}


