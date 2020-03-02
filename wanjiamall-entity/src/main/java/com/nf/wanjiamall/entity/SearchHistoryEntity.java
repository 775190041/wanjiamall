package com.nf.wanjiamall.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 南八
 */
@Data
public class SearchHistoryEntity {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户表的用户id
     */
    private Integer userId;
    /**
     * 搜索关键子
     */
    private String keyword;
    /**
     * 搜索来源 如pc、wx、app
     */
    private String historyFrom;
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
