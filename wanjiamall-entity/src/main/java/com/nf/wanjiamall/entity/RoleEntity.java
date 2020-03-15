package com.nf.wanjiamall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class RoleEntity {

    private Integer id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 启用状态：0->禁用；1->启用
     */
    private Integer enabled;
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
