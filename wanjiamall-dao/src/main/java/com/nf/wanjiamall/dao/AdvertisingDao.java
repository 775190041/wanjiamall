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
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<AdvertisingEntity> getAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,@Param("ad")AdvertisingEntity advertisingEntity);

    /**
     * 通过广告标题，广告内容查相应的广告信息
     * @param pageNum
     * @param pageSize
     * @param name
     * @param content
     * @return
     */
    List<AdvertisingEntity> getByAd(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                                    @Param("adName")String name,@Param("adContent")String content);

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
