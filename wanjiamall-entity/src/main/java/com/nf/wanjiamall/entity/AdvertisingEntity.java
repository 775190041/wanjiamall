package com.nf.wanjiamall.entity;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author lrc
 */
@Data
public class AdvertisingEntity {
    Integer id;
    String name;
    String link;
    String url;
    Integer position;
    String content;
    Date startTime;
    Date endTime;
    Integer enabled;
    Timestamp addTime;
    Timestamp updateTime;
    Integer deleted;
}
