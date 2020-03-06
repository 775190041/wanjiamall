package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.entity.CollectEntity;
import com.nf.wanjiamall.service.CollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 南八
 */
@RestController
@Api(tags = "wanjia_collect")
@RequestMapping("/api")
public class WxCollectController {
    @Autowired
    private CollectService collectService;
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前页码，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "分页大小，必须", required = false),
            @ApiImplicitParam(name = "userId", dataType = "Integer", value = "用户id，必须", required = false)
    })
    @ApiOperation("查询收藏表")
    @GetMapping("/wx_collect/{pageNum}/{pageSize}")
    public Object getCollecByUserId(@PathVariable(required = false) Integer pageNum,
                                 @PathVariable(required = false) Integer pageSize,
                                 @RequestParam("userId") int userId){
        return collectService.getCollectByUserId(pageNum, pageSize, userId);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", dataType = "Integer", value = "用户id，必须", required = false),
            @ApiImplicitParam(name = "goodsId", dataType = "Integer", value = "商品id，必须", required = false)
    })
    @ApiOperation("给收藏表添加或删除某个商品")
    @GetMapping("/wx_collect_add_del")
    public Object getCollectInsertAndDelete(@RequestParam("userId") int userId,
                                            @RequestParam("goodsId") int goodsId){
            return collectService.getCollectInsertAndDelete(userId,goodsId);
    }


}
