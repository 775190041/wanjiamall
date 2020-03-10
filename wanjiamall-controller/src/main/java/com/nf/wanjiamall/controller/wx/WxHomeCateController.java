package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.service.wx.WxHomeCateService;
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
@Api(tags = "home_cate")
@RequestMapping("/wx")
public class WxHomeCateController {
    @Autowired
    private WxHomeCateService wxHomeCateService;

    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", dataType = "Integer", value = "一级类目ID，必须", required = false)
    )

    @ApiOperation("查询二级类目下的所有商品信息")
    @GetMapping("/home/cate/{id}")
    public Object getGoodsData(@RequestParam(name = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                               @PathVariable Integer id){
        return wxHomeCateService.getCateData(pageNum, pageSize, id);
    }
}
