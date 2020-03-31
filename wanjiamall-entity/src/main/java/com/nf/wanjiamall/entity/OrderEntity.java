package com.nf.wanjiamall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrderEntity {
    private Integer id;
    /**
     * 用户表的用户ID
     */
    private Integer userId;
    /**
     * 订单编号
     */
    private String orderSn;
    /**
     * 订单状态 101: 未付款,102: 用户取消,103: 系统取消,201: 已付款,202: 申请退款,203: 已退款,301: 已发货,401: 用户收货,402: 系统收货
     */
    private Integer orderStatus;
    /**
     * 售后状态，0是可申请，1是用户已申请，2是管理员审核通过，3是管理员退款成功，4是管理员审核拒绝，5是用户已取消
     */
    private Integer aftersaleStatus;
    /**
     * 收货人名称
     */
    private String consignee;
    /**
     * 收货人手机号
     */
    private String mobile;
    /**
     * 收货具体地址
     */
    private String address;
    /**
     * 用户订单留言
     */
    private String message;
    /**
     * 商品总费用
     */
    private Double goodsPrice;
    /**
     * 配送费用
     */
    private Double freightPrice;
    /**
     * 优惠券减免
     */
    private Double couponPrice;
    /**
     * 订单费用， = goods_price + freight_price - coupon_price
     */
    private Double orderPrice;
    /**
     * 实付费用， = order_price - integral_price
     */
    private Double actualPrice;
    /**
     * 微信付款编号
     */
    private String payId;
    /**
     * 微信付款时间
     */
    private Date payTime;
    /**
     * 发货编号
     */
    private String shipSn;
    /**
     * 发货快递公司
     */
    private String shipChannel;
    /**
     * 发货开始时间
     */
    private Date shipTime;
    /**
     * 实际退款金额，（有可能退款金额小于实际支付金额）
     */
    private Double refundAmount;
    /**
     * 退款方式 微信
     */
    private String refundType;
    /**
     * 退款备注
     */
    private String refundContent;
    /**
     * 退款时间
     */
    private Date refundTime;
    /**
     * 用户确认收货时间
     */
    private Date confirmTime;
    /**
     * 待评价订单商品数量
     */
    private Integer comments;
    /**
     * 订单关闭时间
     */
    private Date endTime;
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
