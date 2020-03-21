package com.nf.wanjiamall.controller;


import com.nf.wanjiamall.service.AftersaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "wanjia_aftersale")
@RequestMapping("/api")
public class AdminAftersaleController {

    @Autowired
    private AftersaleService aftersaleService;

    @ApiOperation("查询售后信息，售后编号，订单id ，订单状态")
    @GetMapping("/aftersale/{pageNum}/{pageSize}")
    public Object getAftersaleList(@PathVariable Integer pageNum,
                                   @PathVariable Integer pageSize,
                                   @RequestParam(value ="aftersaleSn" ,required = false,defaultValue = "") String aftersaleSn,
                                    @RequestParam(value = "orderId",required = false,defaultValue = "") Integer orderId,
                                    @RequestParam(value = "status",required = false,defaultValue = "") Integer status){
            return aftersaleService.getAftersaleList(pageNum,pageSize,aftersaleSn,orderId,status);
    }

    @ApiOperation("批量拒绝与批量通过")
    @GetMapping("/aftersale/batch")
    public Object batchAudit(@RequestParam(value = "ids" ,required = false,defaultValue = "")List<Integer> ids,
                            @RequestParam(value = "status" ,required = false,defaultValue = "") Integer status){
        return aftersaleService.batchAudit(ids,status);
    }

    @ApiOperation("售后详情,传一个订单id过来")
    @PostMapping("/aftersale/{id}")
    public Object getAftersaleDetail(@PathVariable Integer id){

        return null;

    }


}
