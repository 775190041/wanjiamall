package com.nf.wanjiamall.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lrc
 */
@Data
public class TopicEntity {
    Integer id;
    String title;
    String subtitle;
    String content;
    BigDecimal price;
    Integer readCount;
    String picUrl;
    Integer sortOrder;
    String[] goods;
    String goodes;
    Date addTime;
    Date updateTime;
    Boolean deleted;
    Integer sort;

}
