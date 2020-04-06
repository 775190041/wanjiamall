package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.CouponUserEntity;
import com.nf.wanjiamall.entity.TopicEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lrc
 */

public interface CouponUserDao {
    /**
     * 查询该优惠卷有什么用户领取了
     * @param pageNum
     * @param pageSize
     * @param couponUserEntity
     * @param id
     * @return
     */
    List<CouponUserEntity> getCouponUserByAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                                              @Param("couponUser") CouponUserEntity couponUserEntity,
                                              @Param("id") Integer id);

    /**
     * 根据用户,优惠卷ID查询该用户是否有这条优惠卷
     * @param userId
     * @param couponId
     * @return
     */
    Integer getCouponUserGetByCouponId(@Param("userId") Integer userId,@Param("couponId")Integer couponId);


    /**
     * 根据用户Id查询用户优惠卷所有信息
     */
    List<CouponUserEntity> getUserIdCouponUserAll(@Param("userId") Integer userId);

    /**
     * 根据用户优惠卷Id查询该优惠卷
     */
    CouponUserEntity getUserCouponIdOrUesrId(@Param("userCouponId") Integer userCouponId, @Param("userId") Integer userId);


    /**
     * 该用户领取了其优惠卷
     * @param coupon_id
     * @return
     */
    Integer insertCouponUser(@Param("user_id") Integer user_id, @Param("coupon_id") Integer coupon_id);
}
