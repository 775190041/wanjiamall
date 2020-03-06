package com.nf.wanjiamall.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

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
    String goods;
    Timestamp addTime;
    Timestamp updateTime;
    Boolean deleted;
    Integer sort;
}
