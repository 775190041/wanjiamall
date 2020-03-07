package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.entity.AddressEntity;
import com.nf.wanjiamall.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 南八
 */
@RestController
@Api(tags = "wanjia_address")
@RequestMapping("/api")
public class WxAddressController {

    @Autowired
    private AddressService addressService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前页码，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "分页大小，必须", required = false),
            @ApiImplicitParam(name = "userId", dataType = "Integer", value = "用户id,必须", required = false)
    })

    @GetMapping("/wx_address/{pageNum}/{pageSize}")
    @ApiOperation("按用户id查询该用户所有收货地址")
    public Object getAddressByUserId(@PathVariable(required = false) Integer pageNum,
                                     @PathVariable(required = false) Integer pageSize,
                                     @RequestParam("userId") int userId) {
        return addressService.getAddressByUserId(pageNum,pageSize,userId);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "Integer", value = "id,必须", required = false),
            @ApiImplicitParam(name = "userId", dataType = "Integer", value = "用户id,必须", required = false)
    })

    @GetMapping("/wx_address")
    @ApiOperation("按用户id和收货地址id查询详细地址")
    public Object getAddressByIdAndUserId(@RequestParam("id") Integer id,
                                          @RequestParam("userId") int userId) {
        return addressService.getAddressByIdAndUserId(id,userId);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", dataType = "String", value = "收货人名字，非必须", required = false),
            @ApiImplicitParam(name = "userId", dataType = "Integer", value = "用户表的用户ID，非必须", required = false),
            @ApiImplicitParam(name = "name", dataType = "String", value = "收货人名字，非必须", required = false),
            @ApiImplicitParam(name = "province", dataType = "String", value = "行政区域表的省ID，非必须", required = false),
            @ApiImplicitParam(name = "city", dataType = "String", value = "行政区域表的市ID，非必须", required = false),
            @ApiImplicitParam(name = "country", dataType = "String", value = "行政区域表的区县ID，非必须", required = false),
            @ApiImplicitParam(name = "addressDetail", dataType = "String", value = "详细收货地址，非必须", required = false),
            @ApiImplicitParam(name = "areaCode", dataType = "String", value = "地区编码，非必须", required = false),
            @ApiImplicitParam(name = "postalCode", dataType = "String", value = "邮政编码，非必须", required = false),
            @ApiImplicitParam(name = "tel", dataType = "String", value = "手机号码，非必须", required = false),
            @ApiImplicitParam(name = "isDefault", dataType = "Integer", value = "是否为默认地址 1标识默认地址，非必须", required = false),
            @ApiImplicitParam(name = "add_time", dataType = "Timestamp", value = "创建时间，非必须", required = false),
            @ApiImplicitParam(name = "update_time", dataType = "Timestamp", value = "修改时间，非必须", required = false),
            @ApiImplicitParam(name = "delted", value = "逻辑删除，非必须", required = false)
    })

    @PostMapping("/wx_address")
    @ApiOperation("添加收货地址表")
    public Object addressInsert(@RequestBody AddressEntity addressEntity) {
        return addressService.addressInsert(addressEntity);
    }

    @ApiImplicitParams({

            @ApiImplicitParam(name = "id", dataType = "Integer", value = "地址表的ID，必须", required = false),
            @ApiImplicitParam(name = "userId", dataType = "Integer", value = "用户表的用户ID，必须", required = false),
            @ApiImplicitParam(name = "name", dataType = "String", value = "收货人名字，非必须", required = false),
            @ApiImplicitParam(name = "name", dataType = "String", value = "收货人名字，非必须", required = false),
            @ApiImplicitParam(name = "province", dataType = "String", value = "行政区域表的省ID，非必须", required = false),
            @ApiImplicitParam(name = "city", dataType = "String", value = "行政区域表的市ID，非必须", required = false),
            @ApiImplicitParam(name = "country", dataType = "String", value = "行政区域表的区县ID，非必须", required = false),
            @ApiImplicitParam(name = "addressDetail", dataType = "String", value = "详细收货地址，非必须", required = false),
            @ApiImplicitParam(name = "areaCode", dataType = "String", value = "地区编码，非必须", required = false),
            @ApiImplicitParam(name = "postalCode", dataType = "String", value = "邮政编码，非必须", required = false),
            @ApiImplicitParam(name = "tel", dataType = "String", value = "手机号码，非必须", required = false),
            @ApiImplicitParam(name = "isDefault", dataType = "Integer", value = "是否为默认地址 1标识默认地址，非必须", required = false),
            @ApiImplicitParam(name = "add_time", dataType = "Timestamp", value = "创建时间，非必须", required = false),
            @ApiImplicitParam(name = "update_time", dataType = "Timestamp", value = "修改时间，非必须", required = false),
            @ApiImplicitParam(name = "delted", value = "逻辑删除，非必须", required = false)
    })


    @PutMapping("/wx_address/{id}/{userId}")
    @ApiOperation("修改收货地址表,传一个id和userId过来")
    public Object addressUpdate(@PathVariable("id") Integer id,
                                @PathVariable("userId") Integer userId,
                                @RequestBody AddressEntity addressEntity) {
        return addressService.addressUpdate(id, userId, addressEntity);
    }

    @ApiImplicitParams({

            @ApiImplicitParam(name = "id", dataType = "Integer", value = "地址表的ID，必须", required = false),
            @ApiImplicitParam(name = "userId", dataType = "Integer", value = "用户表的用户ID，必须", required = false),
    })

    @DeleteMapping("/wx_address/{id}/{userId}")
    @ApiOperation("删除收货地址表,传一个id和userId过来")
    public Object addressDelete(@PathVariable("id") Integer id,
                                @PathVariable("userId") Integer userId) {
        return addressService.addressDelete(id, userId);
    }
}
