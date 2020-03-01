package com.nf.wanjiamall.controller;


import com.nf.wanjiamall.service.GoodsService;

import com.nf.wanjiamall.vo.AddGoodsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "wanjia_goods")
@RequestMapping("/api")
public class AdminGoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation("上架商品，以json格式传过来")
    @PostMapping("/goods")
    public Object AddGoods (@RequestBody AddGoodsVo addGoodsVo){
     return goodsService.AddGoods(addGoodsVo);
    }

    @ApiOperation("编辑商品，以json格式传过来,不用通过路径传id，只要把商品id放在json里面")
    @PutMapping("/goods")
    public Object updateGoods(@RequestBody AddGoodsVo addGoodsVo){
        return goodsService.updateGoods(addGoodsVo);
    }

    @ApiOperation("删除商品")
    @DeleteMapping("/goods/{id}")
    public Object deleteGoods(@PathVariable Integer id){
        return goodsService.delete(id);
    }


    @ApiOperation("查询所有商品数据,")
    @GetMapping("/goods/{pageNum}-{pageSize}")
    public Object listGoods(@PathVariable(required = false) int pageNum,
                            @PathVariable(required = false) int pageSize,
                            @RequestParam(value = "id",required = false,defaultValue = "") Integer id,
                            @RequestParam(value = "goodsSn",required = false,defaultValue = "") String goodsSn,
                            @RequestParam(value = "name",required = false,defaultValue = "") String name){

            return goodsService.listGoods(pageNum,pageSize,id,goodsSn,name);
    }





}