package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.AdminDao;
import com.nf.wanjiamall.entity.AdminEntity;
import com.nf.wanjiamall.entity.AdminRoleRelationEntity;
import com.nf.wanjiamall.service.AdminService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired(required = false)
    private AdminDao adminDao;

    @Override
    public Object listAdmin(Integer pageNum, Integer pageSize, String name) {
        List<AdminEntity> adminEntities = adminDao.listAdmin(pageNum,pageSize,name);
        List<AdminEntity> adminEntities1 = new ArrayList<>();
        for (AdminEntity adminEntity : adminEntities) {
            AdminEntity adminEntity1 = new AdminEntity();
            List<AdminRoleRelationEntity> adminRoleRelationEntities = adminDao.getAdminRoleRelationByAdminId(adminEntity.getId());
            List<Integer> roleIds = new ArrayList<>();
            for (AdminRoleRelationEntity adminRoleRelationEntity : adminRoleRelationEntities) {
                roleIds.add(adminRoleRelationEntity.getRoleId());
            }
            adminEntity1.setRoleIds(roleIds);
            adminEntity1.setId(adminEntity.getId());
            adminEntity1.setUsername(adminEntity.getUsername());
            adminEntity1.setPassword(adminEntity.getPassword());
            adminEntity1.setNickName(adminEntity.getNickName());
            adminEntity1.setAvatar(adminEntity.getAvatar());
            adminEntity1.setLoginTime(adminEntity.getLoginTime());
            adminEntity1.setDeletedState(adminEntity.getDeletedState());
            adminEntities1.add(adminEntity1);
        }

        return ResponseUtil.okList(adminEntities1);
    }

    @Transactional
    @Override
    public Object insertAdmin(AdminEntity adminEntity) {
        Integer count = adminDao.insertAdmin(adminEntity);
        List<Integer> roleIds = adminEntity.getRoleIds();
        Integer adminId = adminEntity.getId();
        for (Integer roleId : roleIds) {
            adminDao.insertAdminRoleRelation(roleId,adminId);
        }
        return ResponseUtil.ok("添加成功");
    }

    @Transactional
    @Override
    public Object updateAdmin(Integer id,AdminEntity adminEntity) {
        //修改之前要先把该管理的角色删除点
        adminDao.deleteAdminRoleRelationByAdminId(id);
        //修改
        Integer count = adminDao.updateAdmin(id,adminEntity);

        //添加管理员角色
        List<Integer> roleIds = adminEntity.getRoleIds();
        for (Integer roleId : roleIds) {
            adminDao.insertAdminRoleRelation(roleId,id);
        }
       return ResponseUtil.ok("修改成功");
    }

    @Override
    public Object updateAdminStatus(Integer id, AdminEntity adminEntity) {
        return adminDao.updateAdminStatus(id,adminEntity);
    }

    @Transactional
    @Override
    public Object deleteAdmin(Integer id) {
        adminDao.deleteAdminRoleRelationByAdminId(id);
       Integer count = adminDao.deleteAdmin(id);
       if (count>0){

           return ResponseUtil.ok("删除成功");
       }else {
           return ResponseUtil.fail(505,"删除失败");
       }

    }
}
