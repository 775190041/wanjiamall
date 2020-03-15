package com.nf.wanjiamall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MenuEntity {


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
     * 菜单排序
     */
    private Integer sort;
    /**
     * 前端名称
     */
    private String name;
    /**
     * 前端图标
     */
    private String icon;
    /**
     * 前端隐藏 1表示显示，0表示阴藏
     */
    private Integer hidden;

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
