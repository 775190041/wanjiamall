package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.BrandEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface BrandDao {
    List<BrandEntity> getAll();

    List<BrandEntity> getByConditions(@Param("pageNum") int pageNum,
                                      @Param("pageSize") int pageSize,
                                      @Param("brand") BrandEntity brandEntity);

    int insert(BrandEntity brandEntity);

    int updateById(@Param("brand") BrandEntity entity,Integer id);

    Integer getProductByBrandCount(Integer id);
    void deleteById(Integer id);
}
