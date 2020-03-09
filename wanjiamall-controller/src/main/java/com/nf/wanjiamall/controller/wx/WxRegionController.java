package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.service.wx.WxRegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "wanjia_region")
@RequestMapping("/wx")
public class WxRegionController {

    @Autowired
    private WxRegionService wxRegionService;

    @ApiOperation("查询行政区域省级")
    @GetMapping("/regionProvince")
    public Object getRegionProvinceQuery(){
        return wxRegionService.getRegionProvinceQuery();
    }



    @ApiOperation("查询行政区域 市级、县级、区级")
    @GetMapping("/regionPidCity/{type}/{pId}")
    public Object getRegionPidCityQuery(@PathVariable("type") Integer type, @PathVariable("pId") Integer pId){
        return wxRegionService.getRegionPidCityQuery(type,pId);
    }

}
