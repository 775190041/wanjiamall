package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.service.OrderService;
import com.nf.wanjiamall.service.impl.ExpressService;
import com.nf.wanjiamall.utils.ResponseUtil;
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

    @Autowired
    private ExpressService expressService;
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
    /**
     * 查询物流公司
     *
     * @return
     */
    @GetMapping("/channel")
    public Object channel() {
        return ResponseUtil.ok(expressService.getVendors());
    }


}
