package com.nf.wanjiamall.service;

/**
 * @author lrc
 */

public interface TopicService {
    Object getAll(Integer pageNum, Integer pageSize);

    Object getByTopic(Integer pageNum, Integer pageSize,String title,String subtitle,Integer sort);

//    Object insertAd(AdvertisingEntity advertisingEntity);
//
//    Object updateAd(AdvertisingEntity advertisingEntity, Integer id);
//
//    Object deletedAdId(Integer id);
}
