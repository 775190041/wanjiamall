package com.nf.wanjiamall.service.wx;

import com.nf.wanjiamall.entity.CouponEntity;

import java.math.BigDecimal;

/**
 * @author lrc
 */
public interface WxCouponService {

    Object getCouponAll(Integer pageNum, Integer pageSize, CouponEntity couponEntity);

    Object getCouponById(Integer userId,Integer couponId);

    /**
     * 检查是否有可用和适合的优惠券
     */
    CouponEntity checkCoupon(Integer userId, Integer couponId, Integer userCouponId, BigDecimal checkedGoodsPrice);
}
