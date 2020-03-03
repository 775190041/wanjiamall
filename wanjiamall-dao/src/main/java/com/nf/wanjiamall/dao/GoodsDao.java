package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.GoodsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {
    /**
     * 上架商品，
     */
    int insert(@Param("goodsEntity") GoodsEntity goodsEntity);

    /**
     * 修改商品
     */
    int update(@Param("goods") GoodsEntity goodsEntity);

    /**
     * 删除商品
     */
    int delete(@Param("id") int id);

    /**
     * 查询全部商品
     * @param pageNum
     * @param pageSize
     * @param id
     * @param goodsSn
     * @param name
     * @return
     */
    List<GoodsEntity> listGoods(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize,@Param("id") Integer id,@Param("goodsSn") String goodsSn, @Param("name") String name);

    /**
     * 根据商品id查询商品信息
     */
    GoodsEntity GoodsById(@Param("id") int id);

}
