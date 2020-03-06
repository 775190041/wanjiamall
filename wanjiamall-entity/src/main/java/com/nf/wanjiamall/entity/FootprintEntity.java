package com.nf.wanjiamall.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author 南八
 */
@Data
public class FootprintEntity {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户表的用户id
     */
    private Integer userId;
    /**
     * 商品表的商品id
     */
    private Integer goodsId;
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
    private Integer deleted;

    /**
     * 商品名称
     */
    private String  goodsName;


}
