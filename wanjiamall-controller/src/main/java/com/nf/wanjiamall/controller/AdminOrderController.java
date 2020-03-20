package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "wanjia_order")
@RequestMapping("/api")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("查询所有订单信息")
    @GetMapping("/order/{pageNum}/{pageSize}")
    public Object getOrderList(@PathVariable Integer pageNum,
                               @PathVariable Integer pageSize,
                               @RequestParam(value = "orderStatus" ,required = false,defaultValue = "") List<Integer> orderStatus,
                               @RequestParam(value = "userId" ,required = false,defaultValue = "") Integer userId,
                               @RequestParam(value = "orderSn" ,required = false,defaultValue = "") String orderSn){
        return orderService.getOrderList(pageNum,pageSize,orderStatus,userId,orderSn);
    }

    @ApiOperation("查询某个订单详情信息,传订单id过来")
    @GetMapping("/order/{id}")
    public Object getOrderDetail(@PathVariable Integer id){
            return orderService.getOrderDetail(id);
    }



}
