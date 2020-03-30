package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.CouponUserEntity;
import com.nf.wanjiamall.entity.TopicEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lrc
 */

public interface CouponUserDao {

    List<CouponUserEntity> getCouponUserByAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                                              @Param("couponUser") CouponUserEntity couponUserEntity,
                                              @Param("id") Integer id);

    List<CouponUserEntity> getCouponUserAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("id") Integer id);

    /**
     * 根据用户Id查询用户优惠卷所有信息
     */
    List<CouponUserEntity> getUserIdCouponUserAll(@Param("userId") Integer userId);

    /**
     * 根据用户优惠卷Id查询该优惠卷
     */
    CouponUserEntity getUserCouponIdOrUesrId(@Param("userCouponId") Integer userCouponId, @Param("userId") Integer userId);

}
