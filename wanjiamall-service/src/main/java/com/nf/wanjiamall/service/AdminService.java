package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.AdminEntity;
import com.nf.wanjiamall.vo.AdminLoginParamVo;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {


    Object listAdmin(Integer pageNum,Integer pageSize,String name);

    Object insertAdmin(AdminEntity adminEntity);

    Object updateAdmin(Integer id,AdminEntity adminEntity);

    Object updateAdminStatus(Integer id,AdminEntity adminEntity);

    Object deleteAdmin(Integer id);

    Object adminLogin(AdminLoginParamVo adminLoginParamVo);

    //刷新token
    Object refreshToken(HttpServletRequest request);


    /**
     * 获取用户信息
     * @param username
     * @return
     */
    UserDetails loadUserByUsername(String username);
}
