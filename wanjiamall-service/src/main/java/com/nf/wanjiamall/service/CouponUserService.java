package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.CouponUserEntity;

/**
 * @author lrc
 */

public interface CouponUserService {
    Object getCouponUserAll(Integer pageNum, Integer pageSize,
                            CouponUserEntity couponUserEntity);


//    Object insertAd(AdvertisingEntity advertisingEntity);
//
//    Object updateAd(AdvertisingEntity advertisingEntity, Integer id);
//
//    Object deletedAdId(Integer id);
}
