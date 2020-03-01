package com.nf.wanjiamall.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class GoodsEntity {
    /**
     * 商品ID
     */
    private Integer id;
    /**
     * 商品编号
     */
    private String goodsSn;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品所属类目ID
     */
    private Integer categoryId;
    /**
     * 品牌ID 0表示不属于任何品牌
     */
    private Integer brandId;
    /**
     * 商品宣传图片列表 ，采用JSON数组格式
     */
    private String gallery;
    /**
     * 商品关键字 ，采用逗号分隔
     */
    private String keywords;
    /**
     * 商品简介
     */
    private String brief;
    /**
     * 是否上架
     */
    private String isOnSale;
    /**
     * 是否新品首发 如果设置则可以在新品首发页面展示
     */
    private String isNew;
    /**
     * 是否日期推荐 ，如果设置则可以在人气推荐推荐页面展示
     */
    private String isHot;
    /**
     * 商品单位 ，例如盒，瓶
     */
    private String unit;
    /**
     * 专柜价格
     */
    private Double counterPrice;
    /**
     * 零售价格
     */
    private Double retailPrice;
    /**
     * 商品的详细介绍
     */
    private String detail;
    /**
     * 修改时间
     */

    private Timestamp updateTime;
    /**
     * 创建时间
     */
    private Timestamp addTime;

    /**
     * 逻辑删除
     */
    private String delted;


}
