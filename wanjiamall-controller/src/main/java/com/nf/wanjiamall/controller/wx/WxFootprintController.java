package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.entity.FootprintEntity;
import com.nf.wanjiamall.service.wx.WxFootprintService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "wanjia_footprint")
@RequestMapping("/wx")
public class WxFootprintController {

    @Autowired
    private WxFootprintService wxFootprintService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前页码，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "分页大小，必须", required = false),
            @ApiImplicitParam(name = "addressEntity", dataType = "AddressEntity", value = "收货地址实体类对象(userId,name)，非必须", required = false)
    })
    @ApiOperation("根据用户Id查询用户足迹的所有信息")
    @GetMapping("/footprint/{userId}")
    public Object getUserIdSelectUserFootprint(@PathVariable("userId") Integer userId){
        return  wxFootprintService.getUserIdSelectUserFootprint(userId);
    }

    @DeleteMapping("/footprint/{userId}/{ids}")
    public Object deleteBatchUserFootprint(@PathVariable("userId") Integer userId,@PathVariable("ids") Integer[] ids){
        System.err.println("userId = " + userId);
        System.err.println("ids = " + ids);
        return wxFootprintService.deleteBatchUserFootprint(userId,ids);
    }
}
