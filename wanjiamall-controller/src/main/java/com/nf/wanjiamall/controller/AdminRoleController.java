package com.nf.wanjiamall.controller;


import com.nf.wanjiamall.entity.ResourceEntity;
import com.nf.wanjiamall.entity.RoleEntity;
import com.nf.wanjiamall.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "wanjia_role")
@RequestMapping("/api")
public class AdminRoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("查询所有的角色,根据角色名称查询")
    @GetMapping("/role/{pageNum}/{pageSize}")
    public Object listRole(@PathVariable(required = false) int pageNum,
                               @PathVariable(required = false) int pageSize,
                               @RequestParam(value = "name",required = false,defaultValue = "") String name){
        return roleService.listRole(pageNum,pageSize,name);
    }

    @ApiOperation("添加角色")
    @PostMapping("/role")
    public Object insertRole(@RequestBody RoleEntity roleEntity){
        return roleService.insertRole(roleEntity);
    }

    @ApiOperation("编辑角色 ,把id放入实体类里面")
    @PutMapping("/role/{id}")
    public Object updateRole(@PathVariable Integer id,@RequestBody RoleEntity roleEntity){
        return roleService.updateRole(id,roleEntity);
    }

    @ApiOperation("修改角色状态")
    @PutMapping("/roleStatus/{id}")
    public Object updateRoleStatus(@PathVariable Integer id, @RequestParam(value = "status") Integer status){
        return roleService.updateRoleStatus(id,status);
    }



    @ApiOperation("删除角色")
    @DeleteMapping("/role/{id}")
    public Object deleteRole(@PathVariable Integer id){
        return roleService.deleteRole(id);
    }



}
