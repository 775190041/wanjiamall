package com.nf.wanjiamall.controller.wx;


import com.nf.wanjiamall.service.UserService;
import com.nf.wanjiamall.service.wx.WxUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author lrc
 */
@RestController
@Api(tags = "login")
@RequestMapping("/wx")
public class WxLoginController {
    @Autowired
    private WxUserService userService;

    @ApiOperation("登陆操作")
    @GetMapping("/login/{code}")
    public Object getWxUserOpenid(@PathVariable String code) throws IOException {
        return userService.getWxUserOpenid(code);
    }


}
