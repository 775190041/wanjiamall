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
            @ApiImplicitParam(name = "id", dataType = "Integer", value = "父类目ID，必须", required = false)
    )

    @ApiOperation("查询一级类目下的所有商品信息和二级类目信息")
    @GetMapping("/home/{id}")
    public Object getCateData(@RequestParam(name = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                              @RequestParam(name = "pageSize",required = false,defaultValue = "4") Integer pageSize,
                              @PathVariable Integer id){
        return wxHomeService.getCateData(pageNum,pageSize,id);
    }

    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", dataType = "Integer", value = "二级类目ID，必须", required = false)
    )

    @ApiOperation("查询二级类目下的所有商品信息")
    @GetMapping("/home/cate/{id}")
    public Object getGoodsData(@RequestParam(name = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                              @RequestParam(name = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                              @PathVariable Integer id){
        return wxHomeService.getGoodsData(pageNum,pageSize,id);
    }

}
