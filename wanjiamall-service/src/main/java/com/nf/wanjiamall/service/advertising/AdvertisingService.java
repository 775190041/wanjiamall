package com.nf.wanjiamall.service.advertising;


import com.nf.wanjiamall.entity.AdvertisingEntity;

import java.util.List;

/**
 * @author lrc
 */

public interface AdvertisingService {
    List<AdvertisingEntity> getAll(Integer pageNum, Integer pageSize);

    void updateAd(AdvertisingEntity advertisingEntity, Integer id);
}
