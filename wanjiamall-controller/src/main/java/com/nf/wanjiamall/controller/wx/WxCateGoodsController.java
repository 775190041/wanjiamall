package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.service.wx.WxCateGoodsService;
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
@Api(tags = "wx_cate_goods")
@RequestMapping("/wx")
public class WxCateGoodsController {
    @Autowired
    private WxCateGoodsService wxCateGoodsService;

    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", dataType = "Integer", value = "一级类目ID，必须", required = false)
    )

    @ApiOperation("查询二级类目下的所有商品信息")
    @GetMapping("/cate/goods/{id}")
    public Object getCateGoodsData(@RequestParam(name = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                               @PathVariable Integer id){
        return wxCateGoodsService.getCateGoodsData(pageNum, pageSize, id);
    }
}
