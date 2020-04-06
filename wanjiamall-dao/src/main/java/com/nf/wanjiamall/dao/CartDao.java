package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.CartEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购物车dao
 */
public interface CartDao {

    /**
     *根据用户Id查询购物车所有商品信息
     */
    List<CartEntity> getUserIdQueryCartAll(@Param("userId") Integer userId);

    /**
     * 根据用户Id查询购物车所有勾选得商品
     */
    List<CartEntity> getUserIdQueryCartCheckedGoodsAll(@Param("userId") Integer userId);

    /**
     *根据用户Id与商品id查询购物车信息
     */
    CartEntity getUserIdAndGoodsIduQueryCart(@Param("userId") Integer userId,@Param("id")Integer id);

    /**
     * 根据用户Id查询商品信息
     */
    CartEntity getUserIdQueryCart(@Param("userId")Integer userId);

    /**
     * 加入购物车(购物车实体类添加)
     */
    int insertCart(@Param("cartEntity") CartEntity cartEntity);

    /**
     * 查询购物车中是否存在此规格商品
     */
    CartEntity getExist(@Param("userId") Integer userId,@Param("goodsId")Integer goodsId, @Param("productId") Integer productId);

    /**
     * 修改购物车的商品信息
     * @param cartEntity
     */
    int updateById(@Param("cartEntity") CartEntity cartEntity);

    /**
     * 根据id批量删除购物车商品
    */
    int deleteById(@Param("id")Integer id);

    /**
     * 购物车商品货品勾选状态
     */
    int updateCheck(@Param("cartIds")List<Integer> cartIds,@Param("checked")Integer checked);

    /**
     * 删除购物车商品
     */
    int delete(@Param("cartIds")List<Integer> cartIds , @Param("userId")Integer userId);

}
