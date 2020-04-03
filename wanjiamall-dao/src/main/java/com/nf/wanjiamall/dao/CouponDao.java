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
    List<CouponEntity> getCouponAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("coupon") CouponEntity couponEntity);

    CouponEntity getCouponById(@Param("couponId") Integer couponId);


    Integer insertCouponDay(@Param("coupon") CouponEntity couponEntity);
    Integer insertCouponTime(@Param("coupon") CouponEntity couponEntity);
    Integer insertCouponCodeDay(@Param("coupon") CouponEntity couponEntity);
    Integer insertCouponCodeTime(@Param("coupon") CouponEntity couponEntity);

    Integer updateCouponDay(@Param("coupon") CouponEntity couponEntity, @Param("id") Integer id);
    Integer updateCouponTime(@Param("coupon") CouponEntity couponEntity, @Param("id") Integer id);
    Integer updateCouponCodeDay(@Param("coupon") CouponEntity couponEntity, @Param("id") Integer id);
    Integer updateCouponCodeTime(@Param("coupon") CouponEntity couponEntity, @Param("id") Integer id);


    Integer deletedCouponId(@Param("id") Integer id);
}
