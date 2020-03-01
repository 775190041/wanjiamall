package com.nf.wanjiamall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsProductEntity {

    /**
     * 货品ID
     */
    private Integer id;
    /**
     * 商品表ID
     */
    private Integer goodsId;
    /**
     * 商品规格值列表 ，采用JSON数字
     */
    private String[] specifications;

    private String specification;

    /**
     * 商品货品价格 ，就是这种规格的商品价格
     */
    private Double price;
    /**
     * 商品货品数量
     */
    private Integer number;
    /**
     * 商品货品图片
     */
    private String url;
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
