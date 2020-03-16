package com.nf.wanjiamall.service.wx;

import com.nf.wanjiamall.entity.CartEntity;

/**
 * 购物车 服务
 */
public interface WxCartService {

    /**
     * 根据用户Id查询购物车信息
     */
    Object getUserIdQueryCart(Integer userId);

    /**
     * 根据用户Id和购物车Id批量删除
     */
    Object deleteBatchUserIdRoCartId(Integer userId,Integer[] ids);

    /**
     * 批量修改商品的勾选状态
     */
    Object updateBatchCartChecked(Integer checked, Integer[] ids);

    /**
     * 查询购物车勾选中的的物品数量并进行价格计算
     */
    Object getCartPriceSum();

    /**
     * 修改购物车物品的数量
     */
    Object updateNumber(Integer userId,Integer number,Integer id);

    /**
     * 加入购物车(购物车实体类添加)
     */
    Object insertCart(CartEntity cartEntity);

}
