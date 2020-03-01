package com.nf.wanjiamall.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author 南八
 * 关键字表
 */
@Data
public class KeywordEntity {
    private Integer id;
    private String keyword;
    private String url;
    private String isNot;
    private Timestamp updateTime;
    private Timestamp addTime;
    private String delted;
}
