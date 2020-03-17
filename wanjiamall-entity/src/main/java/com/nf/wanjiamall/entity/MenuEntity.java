package com.nf.wanjiamall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class
MenuEntity {


    private Integer id;
    /**
     * 父级ID
     */
    private Integer parentId;
    /**
     * 菜单名称
     */
    private String title;
    /**
     * 菜单级数
     */
    private Integer level;

    /**
     * 前端名称
     */
    private String name;
    /**
     * 前端图标
     */
    private String icon;


    /**
     * 创建时间
     */
    private Date addTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 逻辑删除
     */
    private String delted;
}
