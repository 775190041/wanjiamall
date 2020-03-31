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
     * 根据用户查询该用户领了什么优惠卷
     * @param pageNum
     * @param pageSize
     * @param username
     * @return
     */
    List<CouponUserEntity> getCouponUserGet(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                                            @Param("username") String username);


    /**
     * 该用户领取了其优惠卷
     * @param username
     * @param coupon_id
     * @return
     */
    Integer insertCouponUser(@Param("username") String username,@Param("coupon_id") Integer coupon_id);
}
