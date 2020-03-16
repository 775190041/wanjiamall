package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.CartEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购物车dao
 */
public interface CartDao {

    /**
     * 根据用户Id查询购物车信息
     */
    List<CartEntity> getUserIdQueryCart(@Param("userId") Integer userId);

    /**
     * 根据用户Id和购物车Id批量删除
     */
    int deleteBatchUserIdRoCartId(@Param("userId") Integer userId,@Param("ids") Integer[] ids);

    /**
     * 批量修改商品的勾选状态
     */
    int updateBatchCartChecked(@Param("checked")Integer checked,@Param("ids") Integer[] ids);

    /**
     * 查询购物车勾选中的的物品数量并进行价格计算
     */
    List<CartEntity> getCartPriceSum();

    /**
     * 修改购物车物品的数量
     */
    int updateNumber(@Param("number")Integer number,@Param("id")Integer id);

    /**
     * 加入购物车(购物车实体类添加)
     */
    int insertCart(@Param("cartEntity") CartEntity cartEntity);

}
