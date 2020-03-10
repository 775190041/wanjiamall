package com.nf.wanjiamall.entity;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author lrc
 */
@Data
public class CouponUserEntity {
    Integer id;
    Integer userId;
    Integer couponId;
    Integer status;
    Date userTime;
    Date startTime;
    Date endTime;
    Integer orderId;
    Timestamp addTime;
    Timestamp updateTime;
    Integer deleted;
}
