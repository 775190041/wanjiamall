package com.nf.wanjiamall.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 购物车实体
 */
@Data
public class CartEntity {

    private Integer id;

    /**
     * 用户表的用户ID
     */
    private Integer userId;
    
    /**
     * 商品编号
     */
    private String goodsSn;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品货品表的货品ID
     */
     private Integer productId;

    /**
     * 商品货品的价格
     */
    private BigDecimal price;

    /**
     * 商品货品的数量
     */
    private Integer number;

    /**
     * 商品规格值列表，采用JSON数组格式
     */
    private String[] specifications;

    private String specification;

    /**
     * 购物车中商品是否选择状态
     */
    private Integer checked;

    /**
     * 商品图片或者商品货品图片
     */
    private String picUrl;

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
    private Integer delted;

}
