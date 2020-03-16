package com.nf.wanjiamall.vo;

import com.nf.wanjiamall.entity.MenuEntity;
import lombok.Data;

import java.util.List;

@Data
public class MenuNode extends MenuEntity {
    private List<MenuNode> children;
}
