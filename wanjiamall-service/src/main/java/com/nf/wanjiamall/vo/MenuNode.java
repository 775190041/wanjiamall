package com.nf.wanjiamall.vo;

import com.nf.wanjiamall.entity.MenuEntity;
import lombok.Data;

import java.util.List;

@Data
public class MenuNode  {
    private Integer id;
    private String title;
    private Integer parentId;
    private List<MenuNode> children;
}
