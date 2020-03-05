package com.nf.wanjiamall.vo;

import com.nf.wanjiamall.entity.CouponEntity;
import com.nf.wanjiamall.entity.CouponUserEntity;
import lombok.Data;

import java.util.List;

/**
 * @author lrc
 */
@Data
public class CouponVO {
    List<CouponEntity> coupon;
    List<CouponUserEntity> couponUser;
}
