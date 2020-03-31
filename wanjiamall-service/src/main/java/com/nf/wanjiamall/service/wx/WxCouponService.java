package com.nf.wanjiamall.service.wx;

import com.nf.wanjiamall.entity.CouponEntity;

/**
 * @author lrc
 */
public interface WxCouponService {

    Object getCouponAll(Integer pageNum, Integer pageSize, CouponEntity couponEntity);

    Object getCouponById(Integer userId,Integer couponId);
}
