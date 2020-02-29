package com.nf.wanjiamall.controller;


import com.nf.wanjiamall.entity.GoodsAttributeEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.entity.GoodsProductEntity;
import com.nf.wanjiamall.entity.GoodsSpecificationEntity;
import com.nf.wanjiamall.service.GoodsService;
import com.nf.wanjiamall.vo.AddGoodsVo;
import com.nf.wanjiamall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "wanjia_goods")
@RequestMapping("/api")
public class GoodsController {
    private GoodsService goodsService;
    @ApiOperation("上架商品，以json格式传过来")
    @PostMapping("/goods/add")
    public ResponseVo AddGoods (@RequestBody AddGoodsVo addGoodsVo){
        
        ResponseVo responseVo = null;
       boolean bool = false;
       if (bool != false){
            return responseVo = new ResponseVo(1,"上架成功","true");
        }else {
            return responseVo = new ResponseVo(1,"上架失败","false");
        }
    }
}