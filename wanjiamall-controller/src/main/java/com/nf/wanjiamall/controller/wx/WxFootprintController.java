package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.entity.FootprintEntity;
import com.nf.wanjiamall.service.wx.WxFootprintService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "wanjia_footprint")
@RequestMapping("/wx")
public class WxFootprintController {

    @Autowired
    private WxFootprintService wxFootprintService;


    @ApiOperation("根据用户Id查询用户足迹的所有信息")
    @GetMapping("/footprint/{userId}")
    public Object getUserIdSelectUserFootprint(@PathVariable("userId") Integer userId){
        return  wxFootprintService.getUserIdSelectUserFootprint(userId);
    }



    @ApiOperation("根据用户Id批量删除用户足迹表Id")
    @DeleteMapping("/footprint/{userId}/{ids}")
    public Object deleteBatchUserFootprint(@PathVariable("userId") Integer userId,@PathVariable("ids") Integer[] ids){
        return wxFootprintService.deleteBatchUserFootprint(userId,ids);
    }
}
