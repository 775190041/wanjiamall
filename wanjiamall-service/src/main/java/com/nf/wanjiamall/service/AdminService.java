package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.AdminEntity;

public interface AdminService {


    Object listAdmin(Integer pageNum,Integer pageSize,String name);

    Object insertAdmin(AdminEntity adminEntity);

    Object updateAdmin(Integer id,AdminEntity adminEntity);

    Object updateAdminStatus(Integer id,AdminEntity adminEntity);
}
