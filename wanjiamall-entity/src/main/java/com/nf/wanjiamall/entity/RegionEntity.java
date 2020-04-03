package com.nf.wanjiamall.entity;

import lombok.Data;

/**
 * 行政区域表
 */
@Data
public class RegionEntity {

    /**
     * 行政区域Id
     */
    private Integer id;

    /**
     * 行政区域父id,列如区县的pid指向市，市的id指向省，省的pid则是0
     */
    private Integer pid;

    /**
     * 行政区域名称
     */
    private String name;

    /**
     * 行政区域类型，如1则是省，如果是2则是市，如果是3则是区县
     */
    private Integer type;

    /**
     * 行政区域编码
     */
    private Integer code;

}
