package com.nf.wanjiamall.service.wx;

import com.nf.wanjiamall.entity.CartEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 购物车 服务
 */
public interface WxCartService {

    /**
     * 根据用户Id查询购物车所有商品信息与计算选中商品的金额
     */
    Object getUserIdQueryCartAll(Integer userId);

    /**
     * 加入购物车(购物车实体类添加)
     */
    Object insertCart(Integer userId , CartEntity cartEntity);

    /**
     * 立即购买
     */
    Object buyImmediately(Integer userId,CartEntity cartEntity);

    /**
     * 修改购物车商品货品数量
     */
    Object updateByGoodsAndProductNumber(Integer userId, CartEntity cartEntity);

    /**
     * 购物车商品货品勾选状态
     */
    Object  checked(Integer userId, String body) ;

    /**
     * 购物车商品删除
     */
    Object delete(Integer userId, String body);

    /**
     * 购物车下单
     */
    Object cartOrders(Integer userId, Integer cartId, Integer addressId, Integer couponId, Integer userCouponId) ;

}
