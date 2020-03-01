package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.GoodsAttributeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsAttributeDao {


    /**
     * 商品参数添加
     */
    int insert(@Param("goodsAttributeEntity") GoodsAttributeEntity goodsAttributeEntity);

    /**
     * 商品参数修改
     */
    int update(@Param("goodsAttr") GoodsAttributeEntity goodsAttributeEntity);

    /**
     * 商品参数删除
     */
    int delete(@Param("id") int id);

    /**
     * 根据商品id查询
     */
    List<GoodsAttributeEntity> listGoodsById(@Param("id") int id);

}
