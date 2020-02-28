package com.nf.wanjiamall.dao.advertising;

import com.nf.wanjiamall.entity.AdvertisingEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lrc
 */
public interface AdvertisingDao {
    List<AdvertisingEntity> getAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    void updateAd(AdvertisingEntity advertisingEntity, Integer id);
}
