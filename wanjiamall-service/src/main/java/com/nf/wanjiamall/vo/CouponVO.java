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
    Object coupon;
    List<CouponUserEntity> couponUser;
}
