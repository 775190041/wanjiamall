package com.nf.wanjiamall.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class FootprintGoodsVo {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 商品表的商品id
     */
    private Integer goodsId;

    /**
     * 创建时间
     */
    private Date addTime;



    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品简介
     */
    private String brief;

    /**
     * 零售价格
     */
    private Double retailPrice;

    /**
     * 商品图片
     */
    private String picUrl;

}
