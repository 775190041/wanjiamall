package com.nf.wanjiamall.controller;


import com.nf.wanjiamall.entity.ResourceEntity;
import com.nf.wanjiamall.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "wanjia_resource")
@RequestMapping("/api")
public class AdminResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation("查询所有资源,根据资源名称和路径查询和资源分类id")
    @GetMapping("/resource/{pageNum}/{pageSize}")
    public Object listResource(@PathVariable(required = false) int pageNum,
                               @PathVariable(required = false) int pageSize,
                               @RequestParam(value = "categoryId",required = false,defaultValue = "") Integer categoryId,
                               @RequestParam(value = "name",required = false,defaultValue = "") String name,
                               @RequestParam(value = "url",required = false,defaultValue = "") String url){
                return resourceService.listResource(pageNum,pageSize,categoryId,name,url);
    }


    @ApiOperation("编辑资源 ,把id放入实体类里面")
    @PutMapping("/resource")
    public Object updateResource(@RequestBody ResourceEntity resourceEntity){
        return resourceService.updateResource(resourceEntity);
    }


    @ApiOperation("根据id 查详细信息")
    @GetMapping("/resource/{id}")
    public Object getByIdResource(@PathVariable Integer id){
        return resourceService.getByIdResource(id);
    }

    @ApiOperation("添加资源")
    @PostMapping("/resource")
    public Object insertResource(@RequestBody ResourceEntity resourceEntity){

        return resourceService.insertResource(resourceEntity);
    }

    @ApiOperation("删除资源")
    @DeleteMapping("/resource/{id}")
    public Object deleteResource(@PathVariable Integer id){
        return resourceService.deleteResource(id);
    }

}
