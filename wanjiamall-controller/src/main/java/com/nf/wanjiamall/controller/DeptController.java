package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.service.DeptService;
import io.swagger.annotations.Api;
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
@Api(tags = "dept123")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept")
    @ApiOperation("获取部门的数量信息")
    public ModelAndView dept(){
        ModelAndView mav=new ModelAndView();
        Integer deptNum=deptService.getDeptCount();
        mav.addObject("deptNum",deptNum);
        mav.setViewName("dept");
        return mav;
    }
}
