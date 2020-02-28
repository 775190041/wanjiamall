package com.nf.wanjiamall.service;


import com.nf.wanjiamall.entity.AdvertisingEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lrc
 */

public interface AdvertisingService {
    List<AdvertisingEntity> getAll(Integer pageNum, Integer pageSize);

    void insertAd(AdvertisingEntity advertisingEntity);

    void updateAd(AdvertisingEntity advertisingEntity, Integer id);

    Integer deletedAdId(Integer id);
}
