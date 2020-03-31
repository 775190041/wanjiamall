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

    BrandEntity getById(@Param("pageNum") Integer pageNum,
                        @Param("pageSize") Integer pageSize,
                        @Param("brandId") Integer brandId);

    int insert(BrandEntity brandEntity);

    int updateById(@Param("brand") BrandEntity entity,Integer id);

    Integer getProductByBrandCount(Integer id);
    int deleteById(Integer id);

    Integer checkExistByName(String name);

    BrandEntity getByGoodId(Integer goodId);
}
