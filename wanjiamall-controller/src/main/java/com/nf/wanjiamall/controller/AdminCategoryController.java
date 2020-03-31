package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzn
 */
@RestController
@Api(tags = "wanjia_category")
@RequestMapping("/api")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;


    @ApiOperation("查询商品类目信息")
    @GetMapping("/category")
    public Object getAllCategory(@RequestParam(name = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                 @RequestParam(name = "pageSize",required = false,defaultValue = Integer.MAX_VALUE+"")Integer pageSize) {
       return categoryService.getAllCategory(pageNum, pageSize);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", dataType = "String", value = "类目名称，非必须", required = false),
            @ApiImplicitParam(name = "category_desc", dataType = "String", value = "类目广告与介绍，非必须", required = false),
            @ApiImplicitParam(name = "level", dataType = "Integer", value = "类目级别 ，1为一级目录，2为二级目录，必须", required = false),
            @ApiImplicitParam(name = "update_time", dataType = "Timestamp", value = "修改时间，非必须", required = false),
            @ApiImplicitParam(name = "add_time", dataType = "Timestamp", value = "创建时间，非必须", required = false),
            @ApiImplicitParam(name = "pid", dataType = "Integer", value = "父类目ID，非必须", required = false),
            @ApiImplicitParam(name = "icon_url", dataType = "String", value = "类目图标，非必须", required = false),
            @ApiImplicitParam(name = "pic_url", dataType = "String", value = "类目图片，非必须", required = false),
            @ApiImplicitParam(name = "delted", value = "逻辑删除，非必须", required = false)
    })

    @ApiOperation("添加商品类目表信息")
    @PostMapping("/category")
    public Object insertCategory(@RequestBody CategoryEntity categoryEntity) {
        return categoryService.insertByLevel(categoryEntity);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", dataType = "String", value = "类目名称，非必须", required = false),
            @ApiImplicitParam(name = "category_desc", dataType = "String", value = "类目广告与介绍，非必须", required = false),
            @ApiImplicitParam(name = "pid", dataType = "Integer", value = "父类目ID，非必须", required = false),
            @ApiImplicitParam(name = "icon_url", dataType = "String", value = "类目图标，非必须", required = false),
            @ApiImplicitParam(name = "pic_url", dataType = "String", value = "类目图片，非必须", required = false),
            @ApiImplicitParam(name = "level", dataType = "Integer", value = "类目级别 ，1为一级目录，2为二级目录，必须", required = false),
            @ApiImplicitParam(name = "update_time", dataType = "Timestamp", value = "修改时间，非必须", required = false),
            @ApiImplicitParam(name = "id", dataType = "Integer", value = "id，必须", required = false)
    })

    @ApiOperation("修改商品类目表信息")
    @PutMapping("/category/{id}")
    public Object updateCategory(@PathVariable Integer id,@RequestBody CategoryEntity categoryEntity) {
        return categoryService.updateById(categoryEntity,id);

    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "Integer", value = "当前选中的id，必须", required = false)
    })

    @ApiOperation("删除商品类目表的信息")
    @DeleteMapping("/category/{id}")
    public Object deleteFirstCategory(@PathVariable Integer id) {
        return categoryService.deleteById(id);
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "level", dataType = "Integer", value = "类目等级，传1返回null，传2返回所有的一级目录", required = false),
    })
    @ApiOperation("查询所有一级目录")
    @GetMapping("/category/l1")
    public Object getDemandCategory(@RequestParam(name = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                    @RequestParam(name = "pageSize",required = false,defaultValue = Integer.MAX_VALUE+"")Integer pageSize) {
        return categoryService.getDemandCategory(pageNum, pageSize);
    }

}
