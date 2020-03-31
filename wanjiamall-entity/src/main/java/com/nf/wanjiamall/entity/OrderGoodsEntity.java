package com.nf.wanjiamall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrderGoodsEntity {

    private Integer id;
    /**
     * 订单表的订单ID
     */
    private Integer orderId;
    /**
     * 商品表的商品ID
     */
    private Integer goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品编号
     */
    private String goodsSn;
    /**
     * 商品货品表的货品ID
     */
    private Integer productId;
    /**
     * 商品货品的购买数量
     */
    private Integer number;
    /**
     * 商品货品的售价
     */
    private Double price;
    /**
     * 商品货品的规格列表
     */
    private String specifications;
    /**
     * 商品货品图片或者商品图片
     */
    private String picUrl;
    /**
     * 订单商品评论，如果是-1，则超期不能评价；如果是0，则可以评价；如果其他值，则是comment表里面的评论ID。
     */
    private Integer comment;
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
    private Object deleted;
}
