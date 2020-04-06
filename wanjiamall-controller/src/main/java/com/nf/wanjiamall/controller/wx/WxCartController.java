package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.entity.CartEntity;
import com.nf.wanjiamall.service.wx.WxCartService;
import com.nf.wanjiamall.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "wanjia_cart")
@RequestMapping("/wx")
public class WxCartController {

    @Autowired
    private WxCartService wxCartService;

    @ApiOperation("根据用户Id查询购物车所有商品信息与计算选中商品的金额")
    @GetMapping("/cart/{userId}")
    public Object getUserIdQueryCart(@PathVariable("userId") Integer userId){
        return wxCartService.getUserIdQueryCartAll(userId);
    }

    @ApiOperation("加入购物车(购物车实体类添加)")
    @PostMapping("/cart/{userId}")
    public Object InsertCart(@PathVariable("userId")Integer userId,@RequestBody CartEntity cartEntity){
        return wxCartService.insertCart(userId,cartEntity);
    }

    @ApiOperation("商品立即购买")
    @PostMapping("/cart/buyImmediately/{userId}")
    public Object buyImmediately(@PathVariable("userId") Integer userId,@RequestBody CartEntity cartEntity){
        return wxCartService.buyImmediately(userId, cartEntity);
    }

    @ApiOperation("修改购物车商品货品数量")
    @PutMapping("/cart/{userId}")
    public Object updateByGoodsAndProductNumber(@PathVariable("userId") Integer userId,@RequestBody CartEntity cartEntity){
        return wxCartService.updateByGoodsAndProductNumber(userId,cartEntity);
    }

    @ApiOperation("购物车商品货品勾选状态")
    @PutMapping("/cart/checked/{userId}")
    public Object checked(@PathVariable("userId") Integer userId, @RequestBody String body) {
        return wxCartService.checked(userId,body);
    }

    @ApiOperation("购物车商品删除")
    @DeleteMapping("/cart/checked/{userId}")
    public Object delete(@PathVariable("userId") Integer userId,@RequestBody  String body){
        return wxCartService.delete(userId, body);
    }

    @ApiOperation("商品确认下单")
    @GetMapping("/cart/cartOrders/{userId}")
     public Object cartOrder(@PathVariable("userId") Integer userId,
                                         @RequestParam(required = false , defaultValue = "0") Integer cartId,
                                         @RequestParam(required = false , defaultValue = "0") Integer addressId,
                                         @RequestParam(required = false , defaultValue = "0")Integer couponId,
                                         @RequestParam(required = false , defaultValue = "0")Integer userCouponId) {
         return wxCartService.cartOrder(userId, cartId, addressId, couponId, userCouponId);
     }
}
