package com.nf.wanjiamall.controller;


import com.nf.wanjiamall.entity.MenuEntity;
import com.nf.wanjiamall.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "wanjia_menu")
@RequestMapping("/api")
public class AdminMenuController {
    @Autowired
    private MenuService menuService;


    @ApiOperation("查询一级菜单列表")
    @GetMapping("/menu/{pageNum}/{pageSize}")
    public Object listMenu(@PathVariable(required = false) int pageNum,
                           @PathVariable(required = false) int pageSize){
        return menuService.listMenu(pageNum,pageSize);
    }

    @ApiOperation("传父id，查详情")
    @GetMapping("/menu/{pid}")
    public Object getByIdMenu(@PathVariable("pid") Integer pid){
        return menuService.getByIdMenu(pid);
    }

    @ApiOperation("按级别查询")
    @GetMapping("/menu/level/{level}")
    public Object getByLevelMenu(@PathVariable("level") Integer level){
        return menuService.getByLevelMenu(level);
    }



    @ApiOperation("添加菜单")
    @PostMapping("/menu")
    public Object insertMenu(@RequestBody MenuEntity menuEntity){
        return menuService.insertMenu(menuEntity);
    }

    @ApiOperation("编辑菜单")
    @PutMapping("/menu/{id}")
    public Object updateMenu(@PathVariable Integer id,@RequestBody MenuEntity menuEntity){
        return menuService.updateMenu(id,menuEntity);
    }

    @ApiOperation("菜单删除")
    @DeleteMapping("/menu/{id}")
    public Object deleteMenu(@PathVariable("id") Integer id){
        return menuService.deleteMenu(id);
    }




    @ApiOperation("树形结构返回所有菜单列表")
    @GetMapping("/treeList")
    public Object TreeList(){
            return menuService.treeList();
    }
}
