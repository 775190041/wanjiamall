package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.GoodsEntity;
import org.apache.ibatis.annotations.Param;

public interface GoodsDao {
    /**
     * 上架商品，
     */
    int insert(@Param("goods") GoodsEntity goodsEntity);

}
