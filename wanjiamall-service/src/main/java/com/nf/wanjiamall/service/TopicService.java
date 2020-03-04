package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.TopicEntity;

/**
 * @author lrc
 */

public interface TopicService {
    Object getAll(Integer pageNum, Integer pageSize, TopicEntity topicEntity);


//    Object insertAd(AdvertisingEntity advertisingEntity);
//
//    Object updateAd(AdvertisingEntity advertisingEntity, Integer id);
//
//    Object deletedAdId(Integer id);
}
