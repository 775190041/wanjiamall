package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    Object listRole(Integer pageNum,Integer pageSize,String name);

    Object insertRole(RoleEntity roleEntity);

    Object updateRole(Integer id,RoleEntity roleEntity);

    Object deleteRole(Integer id);

    Object updateRoleStatus(Integer id,Boolean enabled);

    Object listByIdRoleMenu(Integer id);

    Object RoleAllocationResource(Integer roleId, List<Integer> menuId);


   Object getRole();
}
