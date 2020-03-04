package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.service.TopicService;
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
 * @author lrc
 */
@RestController
@Api(tags = "专题管理")
@RequestMapping("/api")
public class AdminTopicController {
    @Autowired
    private TopicService topicService;

    @ApiOperation(value = "getAll",notes = "获取专题信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码，必须",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "显示数据行多少，必须",required = false, dataType = "Integer")
    })
    @GetMapping("/topic/{pageNum}/{pageSize}")
    public Object getAll(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        return topicService.getAll(pageNum,pageSize);
    }

    @ApiOperation(value = "getByTopic",notes = "根据条件查出相应的专题信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码，必须",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "显示数据行多少，必须",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "title", value = "专题标题",required = false, dataType = "String"),
            @ApiImplicitParam(name = "subtitle", value = "专题子标题",required = false, dataType = "String"),
            @ApiImplicitParam(name = "sort", value = "排序",required = false, dataType = "Integer")
    })
    @GetMapping("/topic/by/{pageNum}/{pageSize}")
    public Object getByTopic(@PathVariable Integer pageNum,@PathVariable Integer pageSize, String title, String subtitle, Integer sort){
        return topicService.getByTopic(pageNum,pageSize,title,subtitle,sort);
    }
}
