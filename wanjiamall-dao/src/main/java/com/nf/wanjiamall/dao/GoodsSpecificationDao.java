package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.GoodsSpecificationEntity;
import org.apache.ibatis.annotations.Param;

public interface GoodsSpecificationDao {
    /**
     * 商品规格添加
     */

    int insert(GoodsSpecificationEntity goodsSpecificationEntity);

    /**
     * 商品规格修改
     */

    int update(@Param("goodsSpec") GoodsSpecificationEntity goodsSpecificationEntity);

    /**
     * 商品规格删除
     */
    int delete(int id);

}
