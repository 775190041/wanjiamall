package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.service.wx.WxBrandService;
import com.nf.wanjiamall.service.wx.WxHomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzn
 */
@RestController
@Api(tags = "wx_brand")
@RequestMapping("/wx")
public class WxBrandController {

    @Autowired
    private WxBrandService wxBrandService;

    @ApiOperation("查询品牌的数据")
    @GetMapping("/brand")
    public Object getHomeData(@RequestParam(name = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                              @RequestParam(name = "pageSize",required = false,defaultValue = "10")Integer pageSize){
        return wxBrandService.getBrandData(pageNum, pageSize);
    }

}
