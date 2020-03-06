package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.SearchHistoryEntity;
import com.nf.wanjiamall.service.SearchHistoryService;
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
@Api(tags = "wanjia_search_history")
@RequestMapping("/api")
public class AdminHistoryController {
    @Autowired
    private SearchHistoryService searchHistoryService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前页码，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "分页大小，必须", required = false),
            @ApiImplicitParam(name = "searchHistoryEntity", dataType = "SearchHistoryEntity", value = "搜索历史实体类对象(userId,keyword)，非必须", required = false)
    })
    @ApiOperation("查询搜索历史表")
    @GetMapping("/searchHistory/{pageNum}/{pageSize}")
    public Object getIssueList(@PathVariable(required = false) Integer pageNum,
                               @PathVariable(required = false) Integer pageSize,
                               SearchHistoryEntity searchHistoryEntity){
        return searchHistoryService.getSearchHistoryList(pageNum, pageSize, searchHistoryEntity);
    }
}