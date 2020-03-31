package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.AdvertisingEntity;
import com.nf.wanjiamall.entity.TopicEntity;
import com.nf.wanjiamall.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            @ApiImplicitParam(name = "pageSize", value = "显示数据行多少，必须",required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "title", value = "专题标题",required = false, dataType = "String"),
            @ApiImplicitParam(name = "subtitle", value = "专题子标题",required = false, dataType = "String"),
            @ApiImplicitParam(name = "sort", value = "排序",required = false, dataType = "Integer")
    })
    @GetMapping("/topic/{pageNum}/{pageSize}")
    public Object getAll(@PathVariable Integer pageNum, @PathVariable Integer pageSize, TopicEntity topicEntity){
        return topicService.getTopicAll(pageNum,pageSize,topicEntity);
    }


    @ApiOperation(value = "insertTopic",notes = "添加专题信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "专题标题",required = false, dataType = "String"),
            @ApiImplicitParam(name = "subtitle", value = "专题子标题",required = false, dataType = "String"),
            @ApiImplicitParam(name = "content", value = "专题内容",required = false, dataType = "String"),
            @ApiImplicitParam(name = "price", value = "最低价格",required = false, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "read_count", value = "专题阅读量",required = false, dataType = "String"),
            @ApiImplicitParam(name = "pic_url", value = "专题图片",required = false, dataType = "String"),
            @ApiImplicitParam(name = "goods", value = "专题商品",required = false, dataType = "String")
    })
    @PostMapping("/topic")
    public Object insertTopic(@RequestBody TopicEntity topicEntity){

        return topicService.insertTopic(topicEntity);
    }

    @ApiOperation(value = "updateTopic",notes = "修改专题信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "专题标题",required = false, dataType = "String"),
            @ApiImplicitParam(name = "subtitle", value = "专题子标题",required = false, dataType = "String"),
            @ApiImplicitParam(name = "content", value = "专题内容",required = false, dataType = "String"),
            @ApiImplicitParam(name = "price", value = "最低价格",required = false, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "read_count", value = "专题阅读量",required = false, dataType = "String"),
            @ApiImplicitParam(name = "pic_url", value = "专题图片",required = false, dataType = "String"),
            @ApiImplicitParam(name = "goods", value = "专题商品",required = false, dataType = "String")
    })
    @PutMapping("/topic/{id}")
    public Object updateTopic(@RequestBody TopicEntity topicEntity, @PathVariable Integer id){
        return topicService.updateTopic(topicEntity,id);
    }


    @ApiOperation(value = "deleteTopicId",notes = "删除该专题信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "专题Id",required = false, dataType = "Integer")
    })
    @DeleteMapping("/topic/{id}")
    public Object deleteTopicId(@PathVariable Integer id){
        return topicService.deleteTopicId(id);
    }


    @ApiOperation(value = "deleteTopicBatchId",notes = "批量删除该专题信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "专题Id",required = false, dataType = "Integer")
    })
    @DeleteMapping("/topic")
    public Object deleteTopicBatchId(Integer[] ids){
        return topicService.deleteTopicBatchId(ids);
    }


    @GetMapping("/topic/{id}")
    public Object getById(@PathVariable("id")Integer id){
        return topicService.getById(id);
    }
}
