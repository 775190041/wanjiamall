package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.AdminDao;
import com.nf.wanjiamall.dao.MenuDao;
import com.nf.wanjiamall.dao.ResourceDao;
import com.nf.wanjiamall.dao.RoleDao;
import com.nf.wanjiamall.entity.*;
import com.nf.wanjiamall.service.AdminService;
import com.nf.wanjiamall.utils.JwtTokenUtil;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.AdminLoginParamVo;
import com.nf.wanjiamall.vo.AdminRoleVo;
import com.nf.wanjiamall.vo.AdminUserDetails;
import com.nf.wanjiamall.vo.MenuNode;
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

    @Autowired(required = false)
    private MenuDao menuDao;

    @Autowired(required = false)
    private RoleDao roleDao;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public Integer adminId;

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
            if (!passwordEncoder.matches(adminLoginParamVo.getPassword(),userDetails.getPassword())){
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
        //返回所有菜单
        List<MenuNode> menuNode = getMenuNode();
        //返回角色名称和用户名
        AdminRoleVo adminRoleVo = getAdminRoleVo();

        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        //返回三级菜单的
        tokenMap.put("menuNode",menuNode);
        tokenMap.put("adminRoleVo",adminRoleVo);

        return ResponseUtil.ok(tokenMap);
    }

    ////返回角色名称和用户名
    public AdminRoleVo getAdminRoleVo(){
        //根据用户账号查询角色名称
        AdminEntity adminEntity = adminDao.getNickByUsername(adminId);
        List<RoleEntity> roleEntities = roleDao.getRoleName(adminId);
        AdminRoleVo adminRoleVo = new AdminRoleVo(roleEntities,adminEntity);
        return adminRoleVo;
    }

    public List<MenuEntity> getMenuEntities(Integer level){
        return menuDao.getMenuByAdminId(adminId,level);
    }

    //通过adminId 差出三级菜单
    public List<MenuNode> getMenuNode(){
       List<MenuEntity> menuEntities = getMenuEntities(1);
       List<MenuNode> menuNodes = new ArrayList<>(menuEntities.size());
        for (MenuEntity menuEntity : menuEntities) {
            MenuNode menuNode = new MenuNode();
            menuNode.setId(menuEntity.getId());
            menuNode.setLevel(menuEntity.getLevel());
            menuNode.setTitle(menuEntity.getTitle());
            menuNode.setName(menuEntity.getName());
            List<MenuEntity> menuEntities1 = menuDao.getByIdMenu(menuEntity.getId());
            List<MenuNode> children = new ArrayList<>(menuEntities1.size());
            for (MenuEntity entity : menuEntities1) {
                MenuNode menuNode1 = new MenuNode();
                menuNode1.setId(entity.getId());
                menuNode1.setLevel(entity.getLevel());
                menuNode1.setTitle(entity.getTitle());
                menuNode1.setName(entity.getName());
                children.add(menuNode1);
                List<MenuEntity> menuEntities2 = menuDao.getByIdMenu(entity.getId());
                List<MenuNode> children2 = new ArrayList<>(menuEntities2.size());
                for (MenuEntity menuEntity1 : menuEntities2) {
                    MenuNode menuNode2 = new MenuNode();
                    menuNode2.setId(menuEntity1.getId());
                    menuNode2.setLevel(menuEntity1.getLevel());
                    menuNode2.setTitle(menuEntity1.getTitle());
                    menuNode2.setName(menuEntity1.getName());

                    children2.add(menuNode2);

                }
                menuNode1.setChildren(children2);

            }
            menuNode.setChildren(children);
            menuNodes.add(menuNode);

        }
        return menuNodes;

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


    @Override
    public UserDetails loadUserByUsername(String username){
        //根据账号获取用户信息
        AdminEntity adminEntity = getAdminByUsername(username);
        if ( adminEntity != null){
            //查询该用户所拥有的访问路径
             adminId = adminEntity.getId();
            List<ResourceEntity> resourceEntities = resourceDao.getResourceByAdminIdList(adminId);
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
        adminEntity.setPassword(passwordEncoder.encode(adminEntity.getPassword()));
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
