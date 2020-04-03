package com.nf.wanjiamall.controller.wx;


import com.nf.wanjiamall.entity.CouponEntity;
import com.nf.wanjiamall.entity.TopicEntity;
import com.nf.wanjiamall.service.CouponService;
import com.nf.wanjiamall.service.TopicService;
import com.nf.wanjiamall.service.wx.WxCouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lrc
 */
@RestController
@Api(tags = "优惠卷")
@RequestMapping("/wx")
public class WxCouponController {

    @Autowired
    private WxCouponService couponService;

    @ApiOperation("查询所有的优惠卷")
    @GetMapping("/coupon")
    public Object getCouponAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                              @RequestParam(name = "pageSize",required = false,defaultValue = "10")Integer pageSize, CouponEntity couponEntity){
        return couponService.getCouponAll(pageNum, pageSize,couponEntity);
    }

    @ApiOperation("领取优惠券并判断该优惠卷是否已领取")
    @GetMapping("/coupon/{userId}/{couponId}")
    public Object getCouponById(@PathVariable Integer userId,@PathVariable Integer couponId){
        return couponService.getCouponById(userId,couponId);
    }
}
