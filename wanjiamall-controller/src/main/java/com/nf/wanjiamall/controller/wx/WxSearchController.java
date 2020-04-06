package com.nf.wanjiamall.controller.wx;

import com.nf.wanjiamall.entity.SearchHistoryEntity;
import com.nf.wanjiamall.service.KeywordService;
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
@Api(tags = "wanjia_keyword,wanjia_search_history")
@RequestMapping("/wx")
public class WxSearchController {
    @Autowired
    private KeywordService keywordService;

    @Autowired
    private SearchHistoryService searchHistoryService;


    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前页码，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "分页大小，必须", required = false),
            @ApiImplicitParam(name = "keyword", dataType = "String", value = "关键字，非必须", required = false)

    })
    @ApiOperation("微信端:查询关键字表")
    @GetMapping("/keyword/{pageNum}/{pageSize}")
    public Object getKeywordList(@PathVariable(required = false) int pageNum,
                                 @PathVariable(required = false) int pageSize,
                                 @RequestParam(value = "keyword",required = false,defaultValue = "") String keyword){
        return keywordService.getKeywordList(pageNum, pageSize,keyword);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前页码，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "分页大小，必须", required = false),
            @ApiImplicitParam(name = "userId", dataType = "Integer", value = "搜索历史表的用户id，必须", required = false)
    })
    @ApiOperation("微信端:按用户id查询搜索历史表")
    @GetMapping("/searchHistory/{pageNum}/{pageSize}")
    public Object getSearchHistoryByUserId(@PathVariable(required = false) int pageNum,
                               @PathVariable(required = false) int pageSize,
                               @RequestParam("userId") int userId){
        return searchHistoryService.getSearchHistoryByUserId(pageNum,pageSize,userId);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", dataType = "Integer", value = "搜索历史表的用户id，必须", required = true)
    })
    @DeleteMapping("/searchHistory/{userId}")
    @ApiOperation("微信端:按用户id删除搜索历史表")
    public Object searchHistoryDelete(@PathVariable("userId") Integer userId){
        return searchHistoryService.searchHistoryDelete(userId);
    }


}
