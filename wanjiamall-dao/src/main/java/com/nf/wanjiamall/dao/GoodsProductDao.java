package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.GoodsProductEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsProductDao {
    /**
     * 商品货物表添加
     */
    int insert(@Param("goodsProductEntity") GoodsProductEntity goodsProductEntity);

    /**
     * 商品货物修改
     */
    int update(@Param("goodsProductEntity") GoodsProductEntity goodsProductEntity);

    /**
     * 商品货物删除
     */
    int delete(@Param("id") int id);

    /**
     * 根据商品id查询
     */

    List<GoodsProductEntity> listByGoodsId(@Param("id") int id);
}
