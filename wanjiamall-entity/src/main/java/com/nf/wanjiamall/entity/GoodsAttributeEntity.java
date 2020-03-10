package com.nf.wanjiamall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class GoodsAttributeEntity {
    /**
     * 参数ID
     */
    private Integer id;
    /**
     * 商品ID
     */
    private Integer goodsId;
    /**
     * 商品参数名称
     */
    private String attribute;
    /**
     * 商品参数值
     */
    private String attributeValue;
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
