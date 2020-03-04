package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.CouponEntity;
import com.nf.wanjiamall.service.CouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags = "优惠卷管理")
@RequestMapping("/api")
public class AdminCouponController {
    @Autowired
    private CouponService couponService;

    @ApiOperation(value = "getAll",notes = "获取优惠卷信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码，必须",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "显示数据行多少，必须",required = false, dataType = "Integer")
    })
    @GetMapping("/coupon/{pageNum}-{pageSize}")
    public Object getAll(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        return couponService.getAll(pageNum,pageSize);
    }

    @ApiOperation(value = "getByCoupon",notes = "获取优惠卷信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码，必须",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "显示数据行多少，必须",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "优惠卷名称",required = false, dataType = "String"),
            @ApiImplicitParam(name = "type", value = "优惠卷类型",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "status", value = "优惠卷状态",required = false, dataType = "Integer")
    })
    @GetMapping("/coupon/by/{pageNum}/{pageSize}")
    public Object getByCoupon(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
                              String name, Integer type, Integer status){
        return couponService.getByCoupon(pageNum,pageSize,name,type,status);
    }

    @ApiOperation(value = "insertCoupon",notes = "添加优惠卷信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "广告标题",required = false, dataType = "String"),
            @ApiImplicitParam(name = "link", value = "广告活动地址",required = false, dataType = "String"),
            @ApiImplicitParam(name = "url", value = "广告图片路径",required = false, dataType = "String"),
            @ApiImplicitParam(name = "position", value = "广告位置",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "content", value = "广告内容",required = false, dataType = "String"),
    })
    @PostMapping("/coupon")
    public Object insertCoupon(CouponEntity couponEntity){
        return couponService.insertCoupon(couponEntity);
    }

    @ApiOperation(value = "updateCoupon",notes = "修改优惠卷信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "要修改广告的ID",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "广告标题",required = false, dataType = "String"),
            @ApiImplicitParam(name = "couponDesc", value = "广告活动地址",required = false, dataType = "String"),
            @ApiImplicitParam(name = "url", value = "广告图片路径",required = false, dataType = "String"),
            @ApiImplicitParam(name = "position", value = "广告位置",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "content", value = "广告内容",required = false, dataType = "String"),
            @ApiImplicitParam(name = "add_time", value = "添加时间",required = false, dataType = "timestamp"),
            @ApiImplicitParam(name = "update_time", value = "修改时间",required = false, dataType = "timestamp"),
            @ApiImplicitParam(name = "deleted", value = "是否删除",required = false, dataType = "Integer")
    })
    @PutMapping("/coupon/{id}")
    public Object updateCoupon(CouponEntity couponEntity, @PathVariable Integer id){
        return couponService.updateCoupon(couponEntity, id);
    }


    @ApiOperation(value = "deletedCouponId",notes = "删除该优惠卷信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "优惠卷Id",required = false, dataType = "Integer")
    })
    @DeleteMapping("/coupon/{id}")
    public Object deletedCouponId(@PathVariable Integer id){
        return couponService.deletedCouponId(id);
    }

}
