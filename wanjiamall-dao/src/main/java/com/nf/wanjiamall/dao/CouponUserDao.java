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

    List<CouponUserEntity> getCouponUserAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,@Param("id") Integer id);

}
