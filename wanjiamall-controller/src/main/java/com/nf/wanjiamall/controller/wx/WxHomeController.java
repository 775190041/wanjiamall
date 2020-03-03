package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.service.wx.WxHomeService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.wx.WxHomeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    public Object getHomeData(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageNum",required = false,defaultValue = "1000")Integer pageSize){
        return wxHomeService.getHomeData(pageNum,pageSize);
    }

}
