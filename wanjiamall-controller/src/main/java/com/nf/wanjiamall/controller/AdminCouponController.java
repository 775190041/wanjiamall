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
            @ApiImplicitParam(name = "pageSize", value = "显示数据行多少，必须",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "优惠卷名称",required = false, dataType = "String"),
            @ApiImplicitParam(name = "type", value = "优惠卷类型",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "status", value = "优惠卷状态",required = false, dataType = "Integer")
    })
    @GetMapping("/coupon/{pageNum}/{pageSize}")
    public Object getAll(@PathVariable Integer pageNum,@PathVariable Integer pageSize,CouponEntity couponEntity){
        return couponService.getCouponAll(pageNum,pageSize,couponEntity);
    }


    @ApiOperation(value = "insertCoupon",notes = "添加优惠卷信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "优惠卷名称",required = false, dataType = "String"),
            @ApiImplicitParam(name = "coupon_Desc", value = "优惠卷介绍",required = false, dataType = "String"),
            @ApiImplicitParam(name = "tag", value = "优惠卷标签",required = false, dataType = "String"),
            @ApiImplicitParam(name = "total", value = "优惠卷数量",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "discount", value = "优惠卷金额",required = false, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "min", value = "最低消费",required = false, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "coupon_limit", value = "用户领卷限制数量",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "type", value = "优惠卷赠送类型",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "status", value = "优惠卷状态",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "goods_type", value = "商品限制类型",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "code", value = "优惠卷兑换码",required = false, dataType = "String"),
            @ApiImplicitParam(name = "time_type", value = "有效时间限制",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "days", value = "使用卷有效天数",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "start_time", value = "使用卷开始时间",required = false, dataType = "datetime"),
            @ApiImplicitParam(name = "end_time", value = "使用卷截至时间",required = false, dataType = "datetime")
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
