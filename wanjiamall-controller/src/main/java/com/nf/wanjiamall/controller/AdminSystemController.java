package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.SystemEntity;
import com.nf.wanjiamall.service.SystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "wanjia_system")
@RequestMapping("/api")
public class AdminSystemController {

    @Autowired
    private SystemService systemService;

    @PutMapping("/systemFreight")
    public Object aa(@PathVariable("systemFreight") SystemEntity systemFreight){

    }



    /*
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", value = "id，必须", required = true),
            @ApiImplicitParam(name = "key_name", dataType = "String", value = "关键字，非必须", required = false),
            @ApiImplicitParam(name = "key_value", dataType = "String", value = "关键字跳转地址，非必须", required = false),
            @ApiImplicitParam(name = "add_time", dataType = "Timestamp", value = "创建时间，非必须", required = false),
            @ApiImplicitParam(name = "update_time", dataType = "Timestamp", value = "修改时间，非必须", required = false),
            @ApiImplicitParam(name = "delted", value = "逻辑删除，非必须", required = false)
    })
    @PutMapping("/system/{id}")
    @ApiOperation("修改系统配置表的运费配置,传一个系统配置表的id过来")
    public Object updateFreight(@PathVariable("id") int id, SystemEntity systemEntity){
        return systemService.updateFreight(id,systemEntity);
    }



    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", value = "id，必须", required = true),
            @ApiImplicitParam(name = "key_name", dataType = "String", value = "关键字，非必须", required = false),
            @ApiImplicitParam(name = "key_value", dataType = "String", value = "关键字跳转地址，非必须", required = false),
            @ApiImplicitParam(name = "add_time", dataType = "Timestamp", value = "创建时间，非必须", required = false),
            @ApiImplicitParam(name = "update_time", dataType = "Timestamp", value = "修改时间，非必须", required = false),
            @ApiImplicitParam(name = "delted", value = "逻辑删除，非必须", required = false)
    })
    @PutMapping("/system/{id}")
    @ApiOperation("修改系统配置表的订单配置,传一个系统配置表的id过来")
    public Object updateOrder(@PathVariable("id") int id, SystemEntity systemEntity){
        return systemService.updateOrder(id,systemEntity);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", value = "id，必须", required = true),
            @ApiImplicitParam(name = "key_name", dataType = "String", value = "关键字，非必须", required = false),
            @ApiImplicitParam(name = "key_value", dataType = "String", value = "关键字跳转地址，非必须", required = false),
            @ApiImplicitParam(name = "add_time", dataType = "Timestamp", value = "创建时间，非必须", required = false),
            @ApiImplicitParam(name = "update_time", dataType = "Timestamp", value = "修改时间，非必须", required = false),
            @ApiImplicitParam(name = "delted", value = "逻辑删除，非必须", required = false)
    })
    @PutMapping("/system/{id}")
    @ApiOperation("修改系统配置表的小程序配置,传一个系统配置表的id过来")
    public Object updateApplet(@PathVariable("id") int id, SystemEntity systemEntity){
        return systemService.updateApplet(id,systemEntity);
    }

     */
}
