package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.SystemEntity;
import com.nf.wanjiamall.service.SystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api(tags = "wanjia_system")
@RequestMapping("/api")
public class AdminSystemController {

    @Autowired
    private SystemService systemService;
    @ApiOperation("查询配置表所有信息")
    @GetMapping("/system")
    public Object systemFreightQuery(){
        return systemService.selectValue();
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", value = "id，必须", required = true),
            @ApiImplicitParam(name = "key_name", dataType = "String", value = "配置名称，必须", required = false),
            @ApiImplicitParam(name = "key_value", dataType = "String", value = "配置值，必须", required = false),
            @ApiImplicitParam(name = "add_time", dataType = "Date", value = "创建时间，必须", required = false),
            @ApiImplicitParam(name = "update_time", dataType = "Date", value = "修改时间，必须", required = false),
            @ApiImplicitParam(name = "delted", value = "逻辑删除，非必须", required = false)
    })
    @ApiOperation("修改系统配置表的运费配置、订单配置、小程序配置,用json格式传一个系统配置表的key_name值和key_value值")
    @PutMapping("/system")
    public Object systemFreightUpdate(@RequestBody String system){
        return  systemService.updateFreight(system);
    }

     */
}
