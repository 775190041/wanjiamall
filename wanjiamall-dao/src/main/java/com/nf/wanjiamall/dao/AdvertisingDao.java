package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.AdvertisingEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lrc
 */
public interface AdvertisingDao {
    List<AdvertisingEntity> getAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    void insertAd(@Param("ad") AdvertisingEntity advertisingEntity);

    void updateAd(@Param("ad") AdvertisingEntity advertisingEntity, @Param("id") Integer id);

    Integer deletedAdId(@Param("id")Integer id);
}
