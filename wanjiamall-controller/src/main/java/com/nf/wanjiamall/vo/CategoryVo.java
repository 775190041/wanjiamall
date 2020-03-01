package com.nf.wanjiamall.vo;


import com.nf.wanjiamall.entity.CategoryEntity;
import lombok.Data;

import java.util.List;

@Data
public class CategoryVo {
    private Integer id;
    private String name;
    private String categoryDesc;
    private Integer pid;
    private String iconUrl;
    private String picUrl;
    private String level;
    private List<CategoryVo> children;
}
