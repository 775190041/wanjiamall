package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.GoodsAttributeEntity;
import org.apache.ibatis.annotations.Param;

public interface GoodsAttributeDao {
    /**
     * 商品参数添加
     */
    int insert( GoodsAttributeEntity goodsAttributeEntity);

    /**
     * 商品参数修改
     */
    int update(@Param("goodsAttr") GoodsAttributeEntity goodsAttributeEntity);

    /**
     * 商品参数删除
     */
    int delete(int id);

}
