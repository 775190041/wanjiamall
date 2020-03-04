package com.nf.wanjiamall.service;


import com.nf.wanjiamall.entity.AdvertisingEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lrc
 */

public interface AdvertisingService {
    Object getAll(Integer pageNum, Integer pageSize,AdvertisingEntity advertisingEntity);

    Object insertAd(AdvertisingEntity advertisingEntity);

    Object updateAd(AdvertisingEntity advertisingEntity, Integer id);

    Object deletedAdId(Integer id);
}
