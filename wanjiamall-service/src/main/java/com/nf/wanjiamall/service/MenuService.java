package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.MenuEntity;

public interface MenuService {

    Object listMenu(Integer pageNum ,Integer pageSize);

    Object insertMenu(MenuEntity menuEntity);

    Object updateMenu(MenuEntity menuEntity);

    Object deleteMenu(Integer id);

    Object getByIdMenu(Integer id);
}
