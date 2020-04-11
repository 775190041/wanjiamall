package com.nf.wanjiamall.service.impl.wx;

import cn.hutool.db.sql.Order;
import com.nf.wanjiamall.dao.*;
import com.nf.wanjiamall.entity.*;
import com.nf.wanjiamall.service.wx.WxCouponService;
import com.nf.wanjiamall.service.wx.WxOrdersService;
import com.nf.wanjiamall.utils.JacksonUtil;
import com.nf.wanjiamall.utils.OrderNumberUtil;
import com.nf.wanjiamall.utils.OrderUtil;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class WxOrderServiceImpl  implements WxOrdersService {

    @Autowired(required = false)
    private OrderDao orderDao;
    @Autowired(required = false)
    private OrderGoodsDao orderGoodsDao;
    @Autowired(required = false)
    private AddressDao addressDao;
    @Autowired(required = false)
    private CartDao cartDao;
    @Autowired(required = false)
    private WxCouponService wxCouponService;
    @Autowired(required = false)
    private SystemDao systemDao;
    @Autowired(required = false)
    private GoodsProductDao goodsProductDao;
    @Autowired(required = false)
    private CouponUserDao couponUserDao;

    @Override
    public Object getQueryAllOrders(Integer pageNum, Integer pageSize, Integer userId, Integer showType) {
        return null;
    }

    @Override
    public Object orderDetail(Integer userId, Integer orderId) {
        return null;
    }

    /**
     * 提交订单
     * <p>
     * 1. 创建订单表项和订单商品表项;
     * 2. 购物车清空;
     * 3. 优惠券设置已用;
     * 4. 商品货品库存减少;
     * 5. 如果是团购商品，则创建团购活动表项。
     * @param userId 用户ID
     * @param body   订单信息，{ cartId：xxx, addressId: xxx, couponId: xxx, message: xxx}
     * @return 提交订单操作结果
     */
    @Override
    public Object orderSubmit(Integer userId, String body) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        if (body == null) {
            return ResponseUtil.badArgument();
        }
        Integer cartId = JacksonUtil.parseInteger(body, "cartId");
        if (cartId == null ){
            cartId = 0;
        }
        Integer addressId = JacksonUtil.parseInteger(body, "addressId");
        Integer couponId = JacksonUtil.parseInteger(body, "couponId");
        Integer userCouponId = JacksonUtil.parseInteger(body, "userCouponId");
        String message = JacksonUtil.parseString(body, "message");

        if (cartId == null || addressId == null || couponId == null) {
            return ResponseUtil.badArgument();
        }

        // 收货地址
        AddressEntity checkedAddress = addressDao.getAddressIdAndUserIdQuery(userId, addressId);
        if (checkedAddress == null) {
            return ResponseUtil.badArgument();
        }

        //货品价格
        List<CartEntity> checkedGoodsList = null ;
        if (cartId.equals(0)){
            checkedGoodsList =  cartDao.getUserIdQueryCartCheckedGoodsAll(userId);
        } else {
            CartEntity cart = cartDao.getUserIdAndGoodsIduQueryCart(userId,cartId);
            checkedGoodsList = new ArrayList<>(1);
            checkedGoodsList.add(cart);
        }
        if (checkedGoodsList.size() == 0) {
            return ResponseUtil.badArgumentValue();
        }

        //选中的商品的价格
        BigDecimal checkedGoodsPrice = new BigDecimal(0.00);
        for (CartEntity cart : checkedGoodsList) {
            //商品价格 * 商品数量
                checkedGoodsPrice = checkedGoodsPrice.add(cart.getPrice().multiply(new BigDecimal(cart.getNumber())));
        }

        // 获取可用的优惠券信息
        // 使用优惠券减免的金额
        BigDecimal couponPrice = new BigDecimal(0);
        // 如果couponId=0则没有优惠券，couponId=-1则不使用优惠券
        if (couponId != 0 && couponId != -1) {
            //查找可用优惠券
            CouponEntity coupon = wxCouponService.checkCoupon(userId, couponId, userCouponId, checkedGoodsPrice);
            if (coupon == null) {
                return ResponseUtil.badArgumentValue();
            }
            //得到优惠券价格
            couponPrice = coupon.getDiscount();
        }

        // 根据订单商品总价计算运费，满足条件（例如88元）则免运费，否则需要支付运费（例如8元）;
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
        Integer orderId = null;
        OrderEntity order = null;
        //订单
        order = new OrderEntity();
        order.setUserId(userId);
        //订单号
        order.setOrderSn(OrderNumberUtil.generateOrderNo());
        //订单生成，未支付
        order.setOrderStatus(OrderUtil.STATUS_CREATE);
        //收货人名称
        order.setConsignee(checkedAddress.getName());
        //号码
        order.setMobile(checkedAddress.getTel());
        //留言
        order.setMessage(message);
        //详细地址
        String detailedAddress = checkedAddress.getProvince() + checkedAddress.getCity() + checkedAddress.getCounty() + " " + checkedAddress.getAddressDetail();
        order.setAddress(detailedAddress);
        //商品总费用
        order.setGoodsPrice(checkedGoodsPrice.doubleValue());
        //配送费用
        order.setFreightPrice(freightPrice.doubleValue());
        //优惠券减免
        order.setCouponPrice(couponPrice.doubleValue());
        //订单费用
        order.setOrderPrice(orderTotalPrice.doubleValue());
        //实际费用
        order.setActualPrice(orderTotalPrice.doubleValue());
        order.setAddTime(new Date());
        order.setUpdateTime(new Date());

        //添加订单
        orderDao.insertOrders(order);
        OrderEntity entity = orderDao.numberQueryOrderId(order.getOrderSn());
        orderId = entity.getId();

        // 添加订单商品表项
        for (CartEntity cartGoods : checkedGoodsList){
            // 订单商品
            OrderGoodsEntity orderGoods = new OrderGoodsEntity();
            orderGoods.setOrderId(order.getId());
            orderGoods.setGoodsId(Integer.parseInt(cartGoods.getGoodsSn()));
            orderGoods.setGoodsSn(cartGoods.getGoodsSn());
            orderGoods.setProductId(cartGoods.getProductId());
            orderGoods.setGoodsName(cartGoods.getGoodsName());
            orderGoods.setPicUrl(cartGoods.getPicUrl());
            orderGoods.setPrice(cartGoods.getPrice().doubleValue());
            orderGoods.setNumber(cartGoods.getNumber());
            orderGoods.setSpecifications(Arrays.toString(cartGoods.getSpecifications()));
            orderGoods.setAddTime(new Date());
            orderGoods.setUpdateTime(new Date());
            //订单商品添加
            orderGoodsDao.insertOrderGoods(orderGoods);
        }

        //查看购物车物品的勾选状态
        List<CartEntity> cartCheckedList = cartDao.getUserIdQueryCartCheckedGoodsAll(userId);
        // 删除购物车里面的商品信息
        for (CartEntity cart : cartCheckedList){
            cartDao.deleteById(cart.getId());
        }

        // 商品货品数量减少
        for (CartEntity checkGoods : checkedGoodsList ){
            Integer productId = checkGoods.getProductId();
            GoodsProductEntity product = goodsProductDao.getProductByGoodsId(productId);
            int remainGoodsProductNumber  = product.getNumber() -  checkGoods.getNumber();
            if (remainGoodsProductNumber < 0) {
                throw new RuntimeException("下单的商品货品数量大于库存量");
            }
            if (goodsProductDao.updateNumber(productId, checkGoods.getNumber()) == 0) {
                throw new RuntimeException("商品货品库存减少失败");
            }
        }

        // 如果使用了优惠券，设置优惠券使用状态
        if (couponId != 0 && couponId != -1) {
            CouponUserEntity couponUser = couponUserDao.getUserCouponIdOrUesrId(userCouponId,userId);
            couponUser.setStatus(1);
            couponUser.setUserTime(new Date());
            couponUser.setOrderId(orderId);
            couponUser.setUserTime(new Date());
            couponUserDao.optionalChange(couponUser);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("orderId", orderId);
        return ResponseUtil.ok(data);
    }

    @Override
    public Object orderCallback() {
        return null;
    }

    @Override
    public Object orderRefund(Integer userId, String body) {
        return null;
    }

    @Override
    public Object orderConfirm(Integer userId, String body) {
        return null;
    }

    @Override
    public Object orderDelete(Integer userId, String body) {
        return null;
    }

    @Override
    public Object orderGoods(Integer userId, Integer orderId, Integer goodsId) {
        return null;
    }

    @Override
    public Object orderComment(Integer userId, String body) {
        return null;
    }
}
