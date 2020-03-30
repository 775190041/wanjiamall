package com.nf.wanjiamall.controller;


import com.nf.wanjiamall.entity.ResourceEntity;
import com.nf.wanjiamall.entity.RoleEntity;
import com.nf.wanjiamall.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Object updateRoleStatus(@PathVariable Integer id, @RequestBody RoleEntity roleEntity){
        return roleService.updateRoleStatus(id,roleEntity.getEnabled());
    }



    @ApiOperation("删除角色")
    @DeleteMapping("/role/{id}")
    public Object deleteRole(@PathVariable Integer id){
        return roleService.deleteRole(id);
    }


    @ApiOperation("根据角色id， 查询该角色拥有的菜单列表")
    @GetMapping("/role/menu/{id}")
    public Object listByIdRoleMenu(@PathVariable Integer id){
        return roleService.listByIdRoleMenu(id);
    }


    @ApiOperation("给角色分配访问菜单,添加和修改都用这个路径 传id和一个菜单的数组")
    @PostMapping("/role/menu/{roleId}")
    public Object RoleAllocationResource(@PathVariable Integer roleId, @RequestBody List<Integer> menuId){
            return roleService.RoleAllocationResource(roleId,menuId);
    }

    @GetMapping("/role")
    public Object getRole(){
        return roleService.getRole();
    }
}
