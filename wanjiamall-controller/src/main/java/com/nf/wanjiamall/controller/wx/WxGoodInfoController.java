package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.service.wx.WxGoodInfoService;
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
@Api(tags = "wx_GoodInfo")
@RequestMapping("/wx")
public class WxGoodInfoController {

    @Autowired
    private WxGoodInfoService wxGoodInfoService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodId", dataType = "Integer", value = "商品id，必须", required = false),
            @ApiImplicitParam(name = "userId", dataType = "Integer", value = "用户id，必须", required = false)

    })

    @ApiOperation("查询商品详情的数据")
    @GetMapping("/good/info/{goodId}/{userId}")
    public Object getGoodInfoData(@PathVariable Integer goodId,@PathVariable Integer userId){
        return wxGoodInfoService.getGoodInfoData(goodId, userId);
    }

}
