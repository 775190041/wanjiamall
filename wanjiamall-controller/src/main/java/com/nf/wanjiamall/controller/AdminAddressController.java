package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.AddressEntity;
import com.nf.wanjiamall.entity.SearchHistoryEntity;
import com.nf.wanjiamall.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 南八
 */
@RestController
@Api(tags = "wanjia_address")
@RequestMapping("/api")
public class AdminAddressController {
    @Autowired
    private AddressService addressService;
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前页码，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "分页大小，必须", required = false),
            @ApiImplicitParam(name = "addressEntity", dataType = "AddressEntity", value = "收货地址实体类对象(userId,name)，非必须", required = false)
    })
    @ApiOperation("查询收货地址表")
    @GetMapping("/address/{pageNum}/{pageSize}")
    public Object getAddressList(@PathVariable(required = false) Integer pageNum,
                                 @PathVariable(required = false) Integer pageSize,
                                 AddressEntity addressEntity){
        return addressService.getAddressList(pageNum, pageSize, addressEntity);
    }
}
