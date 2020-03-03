package com.nf.wanjiamall.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 南八
 */
@Data
public class AddressEntity {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 收货人名称
     */
    private String name;
    /**
     * 用户表的用户ID
     */
    private Integer userId;
    /**
     * 行政区域表的省ID
     */
    private String province;
    /**
     * 行政区域表的市ID
     */
    private String city;
    /**
     * 行政区域表的区县ID
     */
    private String county;
    /**
     * 详细收货地址
     */
    private String addressDetail;
    /**
     * 地区编码
     */
    private String areaCode;
    /**
     * 邮政编码
     */
    private String postalCode;
    /**
     * 手机号码
     */
    private String tel;
    /**
     * 是否默认地址 1表示默认地址
     */
    private boolean isDefault;
    /**
     * 创建时间
     */
    private Date addTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 逻辑删除
     */
    private Integer deleted;

}
