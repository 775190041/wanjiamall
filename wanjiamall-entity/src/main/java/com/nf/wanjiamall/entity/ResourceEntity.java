package com.nf.wanjiamall.entity;


import lombok.Data;

import java.util.Date;

/**
 * @author 黑夜
 */
@Data
public class ResourceEntity {


    private Integer id;
    /**
     * 资源分类ID
     */
    private Integer categoryId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源URL
     */
    private String url;
    /**
     * 描述
     */
    private String description;
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
