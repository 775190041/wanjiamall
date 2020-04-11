package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.service.OrderService;
import com.nf.wanjiamall.service.wx.WxOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "wanjia_Order")
@RequestMapping("/wx")
public class WxOrderController {

    @Autowired
    private WxOrdersService wxOrderService;

    @ApiOperation("提交时生成订单")
    @PostMapping("/order/submit/{userId}")
    public Object submit(@PathVariable("userId") Integer userId,@RequestBody String body){
        return wxOrderService.orderSubmit(userId, body);


    }
}
