package com.nf.wanjiamall.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 系统配置表
 */
@Data
public class SystemEntity {
    /**
     * 配置id
     */
    private Integer id;

    /**
     * 系统配置名
     */
    private String keyName;

    /**
     * 系统配置值
     */
    private String keyValue;

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
    private String delted;


}
