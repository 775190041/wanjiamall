package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.RoleDao;
import com.nf.wanjiamall.entity.MenuEntity;
import com.nf.wanjiamall.entity.RoleEntity;
import com.nf.wanjiamall.service.RoleService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired(required = false)
    private RoleDao roleDao;

    @Override
    public Object listRole(Integer pageNum, Integer pageSize, String name) {
        return ResponseUtil.okList(roleDao.listRole(pageNum,pageSize,name));
    }

    @Override
    public Object insertRole(RoleEntity roleEntity) {
        Integer count = roleDao.insertRole(roleEntity);
        if (count>0){
            return ResponseUtil.ok("添加成功");
        }else {
            return ResponseUtil.fail(505,"添加失败");
        }
    }

    @Override
    public Object updateRole(Integer id,RoleEntity roleEntity) {
        Integer count = roleDao.updateRole(id,roleEntity);
        if (count>0){
            return ResponseUtil.ok("修改成功");
        }else {
            return ResponseUtil.fail(505,"修改失败");
        }


    }

    @Override
    public Object deleteRole(Integer id) {
        Integer count = roleDao.deleteRole(id);

        if (count > 0){
            return ResponseUtil.ok("删除成功");
        }else {
            return ResponseUtil.fail(505,"删除失败");
        }

    }

    @Override
    public Object updateRoleStatus(Integer id,Boolean enabled) {
        Integer count = roleDao.updateRoleStatus(id,enabled);

        if(count>0){
            return ResponseUtil.ok("修改成功");
        }else {
            return ResponseUtil.fail(505,"修改失败");
        }
    }


    @Override
    public Object listByIdRoleMenu(Integer id) {
        return ResponseUtil.ok(roleDao.listByIdRoleMenu(id));
    }

    @Transactional
    @Override
    public Object RoleAllocationResource(Integer roleId, List<Integer> menuId) {
        //先删除 RoleId  所有的菜单  然后才添加
        roleDao.deleteRoleMenuByRoleId(roleId);
        if (menuId.size() == 0){
            return ResponseUtil.ok("成功");
        }else {
            for (Integer integer : menuId) {
                roleDao.insertRoleMenuRelation(roleId,integer);
            }
            return ResponseUtil.ok("成功");
        }


    }
}
