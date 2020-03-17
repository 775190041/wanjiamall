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

    int updateMenu(@Param("id") Integer id,@Param("menuEntity") MenuEntity menuEntity);

    int deleteMenu(@Param("id") Integer id);

    List<MenuEntity> getByIdMenu(@Param("pid") Integer pid);

    List<MenuEntity> getByLevelMenu(@Param("level") Integer level);

    //通过管理员id,获得该管理员的所有菜单
    List<MenuEntity> getMenuByAdminId(@Param("adminId") Integer adminId ,@Param("level") Integer level);




}
