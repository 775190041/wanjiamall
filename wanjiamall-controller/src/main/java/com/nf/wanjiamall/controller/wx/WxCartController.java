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

    @GetMapping("/aa")
    public Object getSS(){
        KdniaoTrackQueryAPI api = new KdniaoTrackQueryAPI();
        String result = null;
        try {
            result = api.getOrderTracesByJson("ANE", "210001633605");
            System.out.print(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseUtil.ok(result);
    }

    @ApiOperation("根据用户Id查询用户足迹的所有信息")
    @GetMapping("/cart/{userId}")
    public Object getUserIdQueryCart(@PathVariable("userId") Integer userId){
        return wxCartService.getUserIdQueryCart(userId);
    }

    @ApiOperation("根据用户Id和购物车Id批量删除")
    @DeleteMapping("/cart/{userId}/{ids}")
    public Object deleteBatchUserIdRoCartId(@PathVariable("userId")Integer userId,@PathVariable("ids")Integer[] ids){
        return wxCartService.deleteBatchUserIdRoCartId(userId, ids);
    }

    @ApiOperation("根据购物车商品Id批量修改商品的勾选状态")
    @PutMapping("/cart/{checked}/{ids}")
    public Object updateBatchCartChecked(@PathVariable("checked")Integer checked,@PathVariable("ids")Integer[] ids){
        return  wxCartService.updateBatchCartChecked(checked,ids);
    }

    @ApiOperation("查询购物车勾选中的的物品数量并进行价格计算")
    @GetMapping("/cart")
    public Object getCartPriceSum(){
        return wxCartService.getCartPriceSum();
    }

    @ApiOperation("查询购物车勾选中的的物品数量并进行价格计算")
    @PutMapping("/cart/{userId}/{number}/{id}")
    public Object updateNumber(@PathVariable("userId")Integer userId,
                               @PathVariable("number")Integer number,
                               @PathVariable("id")Integer id){
        return wxCartService.updateNumber(userId, number, id);
    }

    @ApiOperation("加入购物车(购物车实体类添加)")
    @PostMapping("/cart")
    public Object InsertCart(@RequestParam CartEntity cartEntity){
        return wxCartService.insertCart(cartEntity);
    }
}
