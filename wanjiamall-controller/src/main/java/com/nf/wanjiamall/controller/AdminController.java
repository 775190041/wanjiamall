package com.nf.wanjiamall.controller;


import com.nf.wanjiamall.entity.AdminEntity;
import com.nf.wanjiamall.entity.RoleEntity;
import com.nf.wanjiamall.service.AdminService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.AdminLoginParamVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "wanjia_admin")
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation("查询所有管理员 或者通过管理员账号或者昵称查")
    @GetMapping("/admin/{pageNum}/{pageSize}")
    public Object listAdmin(@PathVariable(required = false) int pageNum,
                           @PathVariable(required = false) int pageSize,
                           @RequestParam(value = "name",required = false,defaultValue = "") String name){
        return adminService.listAdmin(pageNum,pageSize,name);
    }


    @ApiOperation("添加管理员")
    @PostMapping("/admin")
    public Object insertAdmin(@RequestBody AdminEntity adminEntity){
        return adminService.insertAdmin(adminEntity);
    }

    @ApiOperation("修改用户")
    @PutMapping("/admin/{id}")
    public Object updateAdmin(@PathVariable Integer id,@RequestBody AdminEntity adminEntity){
        return adminService.updateAdmin(id,adminEntity);
    }

    @ApiOperation("修改管理员状态状态")
    @PutMapping("/adminStatus/{id}")
    public Object updateAdminStatus(@PathVariable Integer id, @RequestBody AdminEntity adminEntity){
        return adminService.updateAdminStatus(id,adminEntity);
    }

    @ApiOperation("删除管理员")
    @DeleteMapping("/admin/{id}")
    public Object deleteAdmin(@PathVariable Integer id){
        return adminService.deleteAdmin(id);
    }


    @ApiOperation("管理员登录")
    @PostMapping("/admin/login")
    public Object adminLogin(@Valid @RequestBody AdminLoginParamVo adminLoginParamVo, BindingResult bindingResult){
        return adminService.adminLogin(adminLoginParamVo);
    }


    @ApiOperation(value = "刷新token")
    @GetMapping("/refreshToken")
    public Object refreshToken(HttpServletRequest request) {
        return adminService.refreshToken(request);
    }

    @ApiOperation(value = "登出功能")
    @GetMapping("/admin/logout")
    public Object logout(HttpServletRequest request) {
        return adminService.adminLogout(request);
    }


}
