package com.nf.wanjiamall.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author lrc
 */
@Data
public class CouponEntity {
    Integer id;
    String name;
    String couponDesc;
    String tag;
    Integer total;
    BigDecimal discount;
    BigDecimal min;
    Integer couponLimit;
    Integer type;
    Integer status;
    Integer goodsType;
    String[] goodsValue;
    String code;
    Integer timeType;
    Integer days;
    Date startTime;
    Date endTime;
    Integer enabled;
    Timestamp addTime;
    Timestamp updateTime;
    Integer deleted;
}
