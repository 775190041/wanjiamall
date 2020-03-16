package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.AdminEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {

    List<AdminEntity> listAdmin(@Param("pageNum") Integer pageNum,
                                @Param("pageSize") Integer pageSize,
                                @Param("name") String name);



    int insertAdminRoleRelation(@Param("roleId") Integer roleId,@Param("adminId") Integer adminId);

    int insertAdmin(@Param("adminEntity") AdminEntity adminEntity);


    int updateAdmin(@Param("id") Integer id, AdminEntity adminEntity);

}
