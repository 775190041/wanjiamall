package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.AdvertisingEntity;
import com.nf.wanjiamall.entity.CouponEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lrc
 */
public interface CouponDao {
    List<CouponEntity> getAll();

    List<CouponEntity> getCouponAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,@Param("coupon") CouponEntity couponEntity);

    Integer insertCoupon(@Param("coupon") CouponEntity couponEntity);

    Integer updateCoupon(@Param("coupon") CouponEntity couponEntity, @Param("id") Integer id);

    Integer deletedCouponId(@Param("id") Integer id);
}
