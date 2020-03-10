package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.BrandEntity;
import com.nf.wanjiamall.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lzn
 */
@RestController
@Api(tags = "wanjia_brand")
@RequestMapping("/api")
public class AdminBrandController {

    @Autowired
    private BrandService brandService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前所在页，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "页面的数量，必须", required = false),
            @ApiImplicitParam(name = "brandEntity", dataType = "BrandEntity", value = "品牌实体对象（id，name），非必须", required = false)
    })

    @ApiOperation("查询品牌表的信息")
    @GetMapping("/brand/{pageNum}/{pageSize}")
    public Object getBrand(@PathVariable Integer pageNum, @PathVariable Integer pageSize,BrandEntity brandEntity) {
        return brandService.getByConditions(pageNum,pageSize,brandEntity);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", dataType = "String", value = "品牌商名称，非必须", required = false),
            @ApiImplicitParam(name = "brandDesc", dataType = "String", value = "品牌商简介，非必须", required = false),
            @ApiImplicitParam(name = "picUrl", dataType = "String", value = "品牌商页面图片，非必须", required = false),
            @ApiImplicitParam(name = "floorPrice", dataType = "String", value = "商品低价，非必须", required = false),
            @ApiImplicitParam(name = "addTime", dataType = "Timestamp", value = "创建时间，非必须", required = false),
            @ApiImplicitParam(name = "updateTime", dataType = "Timestamp", value = "更新时间，非必须", required = false),
            @ApiImplicitParam(name = "delted", dataType = "String", value = "逻辑删除，非必须", required = false)
    })

    @ApiOperation("添加品牌表的信息")
    @PostMapping("/brand")
    public Object insertBrand(@RequestBody BrandEntity brandEntity) {
        return brandService.insert(brandEntity);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", dataType = "String", value = "品牌商名称，非必须", required = false),
            @ApiImplicitParam(name = "brandDesc", dataType = "String", value = "品牌商简介，非必须", required = false),
            @ApiImplicitParam(name = "picUrl", dataType = "String", value = "品牌商页面图片，非必须", required = false),
            @ApiImplicitParam(name = "floorPrice", dataType = "String", value = "商品低价，非必须", required = false),
            @ApiImplicitParam(name = "id", dataType = "Integer", value = "当前选中行的id，必须", required = false)
    })

    @ApiOperation("修改品牌表的信息")
    @PutMapping("/brand/{id}")
    public Object updateBrand(@RequestBody BrandEntity brandEntity,@PathVariable Integer id) {
        return brandService.updateById(brandEntity,id);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "Integer", value = "当前选中行的id，必须", required = false)
    })

    @ApiOperation("删除品牌表的信息")
    @DeleteMapping("/brand/{id}")
    public Object deleteBrand(@PathVariable Integer id) {
        return brandService.deleteById(id);
    }

}
