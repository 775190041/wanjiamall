package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.AddressEntity;
import com.nf.wanjiamall.entity.CollectEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.service.AddressService;
import com.nf.wanjiamall.service.CollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 南八
 */
@RestController
@Api(tags = "wanjia_collect")
@RequestMapping("/api")
public class AdminCollectController {

    @Autowired
    private CollectService collectService;
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前页码，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "分页大小，必须", required = false),
            @ApiImplicitParam(name = "collectEntity", dataType = "collectEntity", value = "收藏表实体类对象(userId,goodsId,goodsName-即商品名称)，非必须", required = false)
    })
    @ApiOperation("查询搜索历史表")
    @GetMapping("/collect/{pageNum}/{pageSize}")
    public Object getCollectList(@PathVariable(required = false) Integer pageNum,
                                 @PathVariable(required = false) Integer pageSize,
                                 CollectEntity collectEntity, GoodsEntity goodsEntity){
        return collectService.getCollectList(pageNum, pageSize, collectEntity);
    }
}
