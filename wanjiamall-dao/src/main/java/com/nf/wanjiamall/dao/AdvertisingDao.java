package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.AdvertisingEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lrc
 */
public interface AdvertisingDao {


    /**
     * 查询所有的广告信息
     * @return
     */
    List<AdvertisingEntity> getAll();
    List<AdvertisingEntity> getAdAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,@Param("ad")AdvertisingEntity advertisingEntity);


    /**
     * 添加广告信息
     * @param advertisingEntity
     * @return
     */
    Integer insertAd(@Param("ad") AdvertisingEntity advertisingEntity);

    /**
     * 修改广告信息
     * @param advertisingEntity
     * @param id
     * @return
     */
    Integer updateAd(@Param("ad") AdvertisingEntity advertisingEntity, @Param("id") Integer id);

    /**
     * 通过选中的广告Id删除相对应的广告信息
     * @param id
     * @return
     */
    Integer deletedAdId(@Param("id")Integer id);
}
