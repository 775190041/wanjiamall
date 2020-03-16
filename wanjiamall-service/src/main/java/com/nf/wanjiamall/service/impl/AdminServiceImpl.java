package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.AdminDao;
import com.nf.wanjiamall.entity.AdminEntity;
import com.nf.wanjiamall.service.AdminService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired(required = false)
    private AdminDao adminDao;

    @Override
    public Object listAdmin(Integer pageNum, Integer pageSize, String name) {
        return ResponseUtil.okList(adminDao.listAdmin(pageNum,pageSize,name));
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
        //修改之前要先把


        //修改
        Integer count = adminDao.updateAdmin(id,adminEntity);




       return ResponseUtil.ok("修改成功");
    }
}
