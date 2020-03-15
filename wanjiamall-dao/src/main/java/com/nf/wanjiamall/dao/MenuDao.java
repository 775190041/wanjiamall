package com.nf.wanjiamall.dao;


import com.nf.wanjiamall.entity.MenuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 黑夜
 * 菜单
 */
public interface MenuDao {
    //查询
    List<MenuEntity> listMenu(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    int insertMenu(@Param("menuEntity") MenuEntity menuEntity);

    int updateMenu(@Param("menuEntity") MenuEntity menuEntity);

    int deleteMenu(@Param("id") Integer id);

    MenuEntity getByIdMenu(@Param("id") Integer id);
}
