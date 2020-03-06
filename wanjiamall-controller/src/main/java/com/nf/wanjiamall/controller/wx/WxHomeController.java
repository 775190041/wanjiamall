package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.service.wx.WxHomeService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.wx.WxHomeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lzn
 */
@RestController
@Api(tags = "wanjia_category")
@RequestMapping("/wx")
public class WxHomeController {

    @Autowired
    private WxHomeService wxHomeService;

    @ApiOperation("查询主页所有数据")
    @GetMapping("/home")
    public Object getHomeData(){
        return wxHomeService.getHomeData();
    }

    @ApiImplicitParams(
            @ApiImplicitParam(name = "pid", dataType = "Integer", value = "父类目ID，必须", required = false)
    )

    @ApiOperation("查询二级类目及该类目的商品信息")
    @GetMapping("/home/{id}")
    public Object getCateData(@PathVariable Integer pid){
        return wxHomeService.getCateData(pid);
    }

}
