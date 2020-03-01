package com.nf.wanjiamall.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author 南八
 * 常见问题表
 */
@Data
public class IssueEntity {
    private Integer id;
    private String question;
    private String answer;
    private Timestamp updateTime;
    private Timestamp addTime;
    private String delted;
}
