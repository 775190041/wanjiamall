package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.IssueEntity;
import com.nf.wanjiamall.entity.UserEntity;
import com.nf.wanjiamall.service.UserService;
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
@Api(tags = "wanjia_user")
@RequestMapping("/api")
public class AdminUserController{

    @Autowired
    private UserService userService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前页码，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "分页大小，必须", required = false),
            @ApiImplicitParam(name = "username", dataType = "String", value = "用户账号（用户名），非必须", required = false),
            @ApiImplicitParam(name = "mobile", dataType = "String", value = "手机号，非必须", required = false)

    })
    @ApiOperation("查询用户表")
    @GetMapping("/user/{pageNum}/{pageSize}")
    public Object getIssueList(@PathVariable(required = false) Integer pageNum,
                               @PathVariable(required = false) Integer pageSize,
                               @RequestParam(value = "username",required = false,defaultValue = "") String username,
                               @RequestParam(value = "mobile",required = false,defaultValue = "") String mobile){
        return userService.getUserList(pageNum, pageSize, username, mobile);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", value = "id，必须", required = true),
            @ApiImplicitParam(name = "status", dataType = "Integer", value = "用户状态，非必须", required = false)
    })
    @PutMapping("/user/{id}")
    @ApiOperation("修改用户表的转台,传一个用户的id和status过来")
    public Object userUpdate(@PathVariable("id") int id, UserEntity userEntity){
        return userService.userUpdate(id,userEntity);
    }
}
