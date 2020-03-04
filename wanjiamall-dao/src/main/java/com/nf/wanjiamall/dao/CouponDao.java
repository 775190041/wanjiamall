package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.AdvertisingEntity;
import com.nf.wanjiamall.entity.CouponEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lrc
 */
public interface CouponDao {
    List<CouponEntity> getAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    List<CouponEntity> getByCoupon(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                                   @Param("couponName")String name, @Param("couponType")Integer type,
                                   @Param("couponStatus")Integer status);

    void insertCoupon(@Param("coupon") CouponEntity couponEntity);

    void updateCoupon(@Param("coupon") CouponEntity couponEntity, @Param("id") Integer id);

    Integer deletedCouponId(@Param("id") Integer id);
}
