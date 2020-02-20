package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lzn
 */
@Controller
@Api(tags = "部门管理")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept")
    //value 方法的名称 ，notes 方法的描述
    @ApiOperation(value = "dept",notes = "获取部门信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "invoke入参", required = true, dataType = "String", paramType = "get")
    })
    public ModelAndView dept(){
        ModelAndView mav=new ModelAndView();
        Integer deptNum=deptService.getDeptCount();
        mav.addObject("deptNum",deptNum);
        mav.setViewName("dept");
        return mav;
    }
}
