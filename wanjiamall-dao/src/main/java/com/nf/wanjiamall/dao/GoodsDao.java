package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.GoodsEntity;
import org.apache.ibatis.annotations.Param;

public interface GoodsDao {
    /**
     * 上架商品，
     */
    int insert( GoodsEntity goodsEntity);

    /**
     * 修改商品
     */
    int update(@Param("goods") GoodsEntity goodsEntity);

    /**
     * 删除商品
     */
    int delete(int id);

}
