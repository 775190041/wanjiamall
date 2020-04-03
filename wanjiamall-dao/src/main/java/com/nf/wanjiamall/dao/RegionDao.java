package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.RegionEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 行政区域dao
 */
public interface RegionDao {

    /**
     * 查询行政区域 省
     */
    List<RegionEntity>  getRegionProvinceQuery();

    /**
     *  查询行政区域 市 县
     */
    List<RegionEntity> getRegionPidCityQuery(@Param("type") Integer type,@Param("pId") Integer pId);


}
