package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.service.wx.WxBrandGoodsService;
import com.nf.wanjiamall.service.wx.WxCateGoodsService;
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
@Api(tags = "wx_brand_goods")
@RequestMapping("/wx")
public class WxBrandGoodsController {
    @Autowired
    private WxBrandGoodsService wxBrandGoodsService;

    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", dataType = "Integer", value = "品牌ID，必须", required = false)
    )

    @ApiOperation("查询该品牌的所有商品信息")
    @GetMapping("/brand/goods/{id}")
    public Object getCateGoodsData(@RequestParam(name = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                               @PathVariable Integer id){
        return wxBrandGoodsService.getBrandGoodsData(pageNum, pageSize, id);
    }
}
