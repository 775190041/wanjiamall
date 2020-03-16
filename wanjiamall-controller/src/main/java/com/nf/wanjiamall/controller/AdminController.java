package com.nf.wanjiamall.controller;


import com.nf.wanjiamall.entity.AdminEntity;
import com.nf.wanjiamall.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return adminService.updateAdmin( id,adminEntity);
    }

}
