package com.nf.wanjiamall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsSpecificationEntity {

    /**
     * 规格ID
     */
    private Integer id;
    /**
     * 商品表ID
     */
    private Integer goodsId;
    /**
     * 商品规格名称
     */
    private String specification;
    /**
     * 商品规格值
     */
    private String specificationValue;
    /**
     * 商品规格图片
     */
    private String picUrl;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 创建时间
     */
    private Date addTime;
    /**
     * 逻辑删除
     */
    private String delted;

}
