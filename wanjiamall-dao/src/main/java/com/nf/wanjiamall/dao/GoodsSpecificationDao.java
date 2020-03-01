package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.GoodsSpecificationEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsSpecificationDao {
    /**
     * 商品规格添加
     */

    int insert(@Param("goodsSpecificationEntity") GoodsSpecificationEntity goodsSpecificationEntity);

    /**
     * 商品规格修改
     */

    int update(@Param("goodsSpec") GoodsSpecificationEntity goodsSpecificationEntity);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(@Param("id") int id);

    List<GoodsSpecificationEntity> listGoodsById(@Param("id") int id);

}
