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
 * @author lzn123
 */
@RestController
@Api(tags = "wanjia_category")
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前页码，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "分页大小，必须", required = false)
    })

    @ApiOperation("查询商品类目表信息")
    @GetMapping("/category/{pageNum}-{pageSize}")
    public ResponseVo getCategory(@PathVariable(required = false) int pageNum, @PathVariable(required = false) int pageSize) {
        List<CategoryEntity> cateLists = categoryService.getCateAll(pageNum, pageSize);
        return ResponseVo.getSuccess("ok",cateLists);
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
        if (Integer.valueOf(categoryEntity.getLevel()) == 1) {
            categoryService.insertByLevelFirst(categoryEntity);
            return ResponseVo.getSuccess("ok","添加成功！");
        } else if (Integer.valueOf(categoryEntity.getLevel()) == 2) {
            categoryService.insertByLevelSecond(categoryEntity);
            return ResponseVo.getSuccess("ok","添加成功！");
        } else {
            return ResponseVo.getSuccess("no","添加失败！");
        }
    }

//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "name", dataType = "String", value = "类目名称，非必须", required = false),
//            @ApiImplicitParam(name = "category_desc", dataType = "String", value = "类目广告与介绍，非必须", required = false),
//            @ApiImplicitParam(name = "pid", dataType = "Integer", value = "父类目ID，非必须", required = false),
//            @ApiImplicitParam(name = "icon_url", dataType = "String", value = "类目图标，非必须", required = false),
//            @ApiImplicitParam(name = "pic_url", dataType = "String", value = "类目图片，非必须", required = false),
//            @ApiImplicitParam(name = "level", dataType = "Integer", value = "类目级别 ，1为一级目录，2为二级目录，必须", required = false),
//            @ApiImplicitParam(name = "update_time", dataType = "Timestamp", value = "修改时间，非必须", required = false),
//            @ApiImplicitParam(name = "id", dataType = "Integer", value = "id，必须", required = false)
//    })
//
//    @ApiOperation("修改商品类目表信息")
//    @PutMapping("/category/id")
//    public ResponseVo updateCategory(CategoryEntity categoryEntity,@PathVariable Integer id) {
//        categoryService.updateById(categoryEntity,id);
//        return ResponseVo.getSuccess("ok","修改成功");
//    }


}
