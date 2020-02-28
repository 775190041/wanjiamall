package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.service.impl.CategoryServiceImpl;
import com.nf.wanjiamall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lzn
 */
@RestController
@Api(tags = "wanjia_category")
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @ApiOperation("查询商品父类目信息")
    @GetMapping("/category")
    public ResponseVo getFirstCategory() {
        List<CategoryEntity> cateFirstLists = categoryService.getFirstCate();
        return ResponseVo.getSuccess("ok",cateFirstLists);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", dataType = "Integer", value = "获取当前父类目的id，必须", required = false)
    })

    @ApiOperation("查询商品二级类目信息")
    @GetMapping("/category/{pid}")
    public ResponseVo getCategory(@PathVariable Integer pid) {
        List<CategoryEntity> cateSecondLists = categoryService.getSecondCate(pid);
        return ResponseVo.getSuccess("ok",cateSecondLists);
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
    public ResponseVo insertCategory(CategoryEntity categoryEntity) {
        categoryService.insertByLevel(categoryEntity);
        return ResponseVo.getSuccess("ok","添加成功！");
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
    public ResponseVo updateCategory(@PathVariable Integer id,CategoryEntity categoryEntity) {
        categoryService.updateById(categoryEntity,id);
        return ResponseVo.getSuccess("ok","修改成功");
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "Integer", value = "当前选中的id，必须", required = false)
    })

    @ApiOperation("删除商品类目表的信息")
    @DeleteMapping("/category/{id}")
    public ResponseVo deleteFirstCategory(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return ResponseVo.getSuccess("ok","执行成功");
    }



}
