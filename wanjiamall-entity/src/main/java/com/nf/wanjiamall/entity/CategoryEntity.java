package com.nf.wanjiamall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author lzn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
    private Integer id;
    private String name;
    private String categoryDesc;
    private Integer pid;
    private String iconUrl;
    private String picUrl;
    private String level;
    private Timestamp updateTime;
    private Timestamp addTime;
    private String delted;
}
