package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.CartDao;
import com.nf.wanjiamall.entity.CartEntity;
import com.nf.wanjiamall.service.wx.WxCartService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购车车 实现类
 */
@Service
@Slf4j
public class WxCartServiceImpl implements WxCartService {

    @Autowired
    private CartDao cartDao;

    /**
     * 根据用户Id查询购物车信息
     * @param userId
     * @return
     */
    @Override
    public Object getUserIdQueryCart(Integer userId) {
        if (userId != null){
            return ResponseUtil.ok(cartDao.getUserIdQueryCart(userId));
        }else{
            return ResponseUtil.fail(501,"请登录!");
        }
    }

    /**
     * 根据用户Id和购物车Id批量删除
     * @param userId
     * @param ids
     * @return
     */
    @Override
    public Object deleteBatchUserIdRoCartId(Integer userId, Integer[] ids) {
        log.debug("------->>>>cart id的个数："+ ids.length);
        if (cartDao.deleteBatchUserIdRoCartId(userId,ids) > 0){
            return ResponseUtil.ok();
        }else{
            return ResponseUtil.fail(505,"删除失败");
        }
    }

    /**
     * 批量修改商品的勾选状态
     * @param checked
     * @param ids
     * @return
     */
    @Override
    public Object updateBatchCartChecked(Integer checked, Integer[] ids) {
        log.debug("------->>>>cart id的个数："+ ids.length);
        if (cartDao.updateBatchCartChecked(checked,ids) > 0){
            return ResponseUtil.ok();
        }else{
            return ResponseUtil.fail(505,"修改失败");
        }
    }

    /**
     * 查询购物车勾选中的的物品数量并进行价格计算
     * @return
     */
    @Override
    public Object getCartPriceSum() {
        List<CartEntity>  list = cartDao.getCartPriceSum();
        int sum = 0;
        for (CartEntity cart : list){
           sum += cart.getPrice().intValue() * cart.getNumber();
        }
        System.err.println("sum = " + sum);
        return ResponseUtil.ok(sum);
    }

    /**
     * 修改购物车物品的数量
     * @param userId
     * @param number
     * @param id
     * @return
     */
    @Override
    public Object updateNumber(Integer userId,Integer number, Integer id) {
        if (userId != null){
            if( cartDao.updateNumber(number, id) > 0){
                return ResponseUtil.ok();
            }else{
                return ResponseUtil.fail(505,"修改失败");
            }
        }else{
            return ResponseUtil.fail(501,"请登录");
        }
    }

    /**
     * 加入购物车(购物车实体类添加)
     * @param cartEntity
     * @return
     */
    @Override
    public Object insertCart(CartEntity cartEntity) {
        if(cartDao.insertCart(cartEntity) >0 ){
            return ResponseUtil.ok();
        }else{
            return ResponseUtil.fail(505,"添加失败");
        }
    }
}
