package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.CouponEntity;
import com.nf.wanjiamall.entity.CouponUserEntity;

import java.util.List;

/**
 * @author lrc
 */
public interface CouponService {
    Object getCouponAll(Integer pageNum, Integer pageSize,
                        CouponEntity couponEntity);

    Object getCouponById(Integer pageNum,Integer pageSize,Integer id,CouponUserEntity couponUserEntity);

    Object insertCoupon(CouponEntity couponEntity);

    Object updateCoupon(CouponEntity couponEntity, Integer id);

    Object deletedCouponId(Integer id);

    Object getCouponIdQuery(Integer couponId);
}
