package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.CouponEntity;
import java.util.List;

/**
 * @author lrc
 */
public interface CouponService {
    Object getAll(Integer pageNum, Integer pageSize);

    Object getByCoupon(Integer pageNum,Integer pageSize,String name,Integer type,Integer status);

    Object insertCoupon(CouponEntity couponEntity);

    Object updateCoupon(CouponEntity couponEntity, Integer id);

    Object deletedCouponId(Integer id);
}