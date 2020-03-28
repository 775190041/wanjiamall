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
   private  Integer id;
    private String name;
    private String couponDesc;
    private String tag;
    private  Integer total;
    private  BigDecimal discount;
    private  BigDecimal min;
    private  Integer couponLimit;
    private  Integer type;
    private  Integer status;
    private  Integer goodsType;
    private  String goodsValue;
    private String code;
    private  Integer timeType;
    private Integer days;
    private Date startTime;
    private  Date endTime;
    private  Integer enabled;
    private Timestamp addTime;
    private Timestamp updateTime;
    private Integer deleted;

}
