package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.KeywordEntity;
import com.nf.wanjiamall.service.KeywordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * @author 南八
 */
@RestController
@Api(tags = "wanjia_keyword")
@RequestMapping("/api")
public class AdminKeywordController {
    @Autowired
    private KeywordService keywordService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前页码，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "分页大小，必须", required = false),
            @ApiImplicitParam(name = "keyword", dataType = "String", value = "关键字，非必须", required = false)

    })
    @ApiOperation("查询关键字表")
    @GetMapping("/keyword/{pageNum}-{pageSize}")
    public Object getKeywordList(@PathVariable(required = false) int pageNum,
                                     @PathVariable(required = false) int pageSize,
                                     @RequestParam(value = "keyword",required = false,defaultValue = "") String keyword){
        return keywordService.getKeywordList(pageNum, pageSize,keyword);
    }



    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", dataType = "String", value = "关键字，非必须", required = false),
            @ApiImplicitParam(name = "url", dataType = "String", value = "关键字跳转地址，非必须", required = false),
            @ApiImplicitParam(name = "is_not", dataType = "String", value = "是否为热门关键字，非必须", required = false)
    })
    @PostMapping("/keyword")
    @ApiOperation("添加关键字表")
    public Object keywordInsert(KeywordEntity keywordEntity) throws ParseException {
       return keywordService.keywordInsert(keywordEntity);
    }



    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", value = "id，必须", required = true),
            @ApiImplicitParam(name = "keyword", dataType = "String", value = "关键字，非必须", required = false),
            @ApiImplicitParam(name = "url", dataType = "String", value = "关键字跳转地址，非必须", required = false),
            @ApiImplicitParam(name = "is_not", dataType = "String", value = "是否为热门关键字，非必须", required = false),
            @ApiImplicitParam(name = "add_time", dataType = "Timestamp", value = "创建时间，非必须", required = false),
            @ApiImplicitParam(name = "update_time", dataType = "Timestamp", value = "修改时间，非必须", required = false),
            @ApiImplicitParam(name = "delted", value = "逻辑删除，非必须", required = false)
    })
    @PutMapping("/keyword/{id}")
    @ApiOperation("修改关键字表,传一个关键字表的id过来")
    public Object keywordUpdate(@PathVariable("id") int id,KeywordEntity keywordEntity){
        return keywordService.keywordUpdate(id,keywordEntity);
    }



    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", value = "id，必须", required = true)
    })
    @DeleteMapping("/keyword/{id}")
    @ApiOperation("删除常见问题表")
    public Object keywordDelete(@PathVariable("id") int id){
        return keywordService.keywordDelete(id);
    }

}
