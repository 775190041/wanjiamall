package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.AdminDao;
import com.nf.wanjiamall.dao.ResourceDao;
import com.nf.wanjiamall.entity.AdminEntity;
import com.nf.wanjiamall.entity.AdminRoleRelationEntity;
import com.nf.wanjiamall.entity.ResourceEntity;
import com.nf.wanjiamall.service.AdminService;
import com.nf.wanjiamall.utils.JwtTokenUtil;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.AdminLoginParamVo;
import com.nf.wanjiamall.vo.AdminUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired(required = false)
    private AdminDao adminDao;

    @Autowired(required = false)
    private ResourceDao resourceDao;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    //登录 登录成功，就返回一个令牌给前端
    @Override
    public Object adminLogin(AdminLoginParamVo adminLoginParamVo) {
        String token = null;
        try {
            UserDetails userDetails = loadUserByUsername(adminLoginParamVo.getUsername());
            if (!passwordEncoder.matches(adminLoginParamVo.getUsername(),userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
            //登录成功后，需要把用户的登录时间添加进去
            insertLoginLog(adminLoginParamVo.getUsername());
        }catch (AuthenticationException e) {
            log.warn("登录异常", e.getMessage());
        }
        if (token == null){
            return ResponseUtil.fail(500,"用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return ResponseUtil.ok(tokenMap);
    }

    //刷新token
    @Override
    public Object refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = jwtTokenUtil.refreshHeadToken(token);
        if (refreshToken == null){
            return ResponseUtil.fail(500,"token 过期");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return ResponseUtil.ok(tokenMap);
    }


    public UserDetails loadUserByUsername(String username){
        //根据账号获取用户信息
        AdminEntity adminEntity = getAdminByUsername(username);
        if ( adminEntity != null){
            //查询该用户所拥有的访问路径
            List<ResourceEntity> resourceEntities = resourceDao.getResourceByAdminIdList(adminEntity.getId());
            return new AdminUserDetails(adminEntity,resourceEntities);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    public AdminEntity getAdminByUsername(String username){
            return adminDao.getAdminByUsername(username);
    }

    //更新登录时间
    public void insertLoginLog(String username){
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setUsername(username);
        adminEntity.setLoginTime(new Date());
        adminDao.insertLoginLog(adminEntity);
    }









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
