package com.nf.wanjiamall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date endTime;
    Boolean enabled;
    Timestamp addTime;
    Timestamp updateTime;
    Integer deleted;
}
