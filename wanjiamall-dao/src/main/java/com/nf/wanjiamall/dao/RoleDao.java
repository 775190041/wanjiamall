package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    List<RoleEntity> listRole(@Param("pageNum") Integer pageNum,
                              @Param("pageSize") Integer pageSize,
                              @Param("name") String name);

    int insertRole(@Param("roleEntity") RoleEntity roleEntity);


    int updateRole(@Param("id") Integer id,@Param("roleEntity") RoleEntity roleEntity);

    int deleteRole(@Param("id") Integer id);


    int updateRoleStatus(@Param("id") Integer id,@Param("enabled") Integer status);

}
