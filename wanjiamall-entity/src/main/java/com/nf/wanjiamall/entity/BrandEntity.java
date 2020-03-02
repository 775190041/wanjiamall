package com.nf.wanjiamall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author lzn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
