package com.nf.wanjiamall.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author lzn
 */
@Data
public class BrandEntity {
    private Integer id;
    private String name;
    private String brandDesc;
    private String picUrl;
    private String floorPrice;
    private Timestamp addTime;
    private Timestamp updateTime;
    private String delted;


}
