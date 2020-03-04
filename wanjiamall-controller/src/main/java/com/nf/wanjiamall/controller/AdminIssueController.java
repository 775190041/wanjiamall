package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.IssueEntity;
import com.nf.wanjiamall.service.IssueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 南八
 */
@RestController
@Api(tags = "wanjia_issue")
@RequestMapping("/api")
public class AdminIssueController {

    @Autowired
    private IssueService issueService;
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前页码，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "分页大小，必须", required = false),
            @ApiImplicitParam(name = "question", dataType = "String", value = "问题标题，非必须", required = false)

    })

   @ApiOperation("查询常见问题表")
   @GetMapping("/issue/{pageNum}/{pageSize}")
   public Object getIssueList(@PathVariable(required = false) int pageNum,
                                  @PathVariable(required = false) int pageSize,
                                  @RequestParam(value = "question",required = false,defaultValue = "") String question){
       return issueService.getIssueList(pageNum, pageSize,question);
   }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "question", dataType = "String", value = "问题标题，非必须", required = false),
            @ApiImplicitParam(name = "answer", dataType = "String", value = "问题答案，非必须", required = false),
            @ApiImplicitParam(name = "add_time", dataType = "Timestamp", value = "创建时间，非必须", required = false),
            @ApiImplicitParam(name = "update_time", dataType = "Timestamp", value = "修改时间，非必须", required = false),
            @ApiImplicitParam(name = "delted", value = "逻辑删除，非必须", required = false)
    })

    @PostMapping("/issue")
    @ApiOperation("添加常见问题表")
    public Object issueInsert(IssueEntity issueEntity) {
        return issueService.issueInsert(issueEntity);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", value = "id，必须", required = true),
            @ApiImplicitParam(name = "question", dataType = "String", value = "问题标题，非必须", required = false),
            @ApiImplicitParam(name = "answer", dataType = "String", value = "问题答案，非必须", required = false),
            @ApiImplicitParam(name = "add_time", dataType = "Timestamp", value = "创建时间，非必须", required = false),
            @ApiImplicitParam(name = "update_time", dataType = "Timestamp", value = "修改时间，非必须", required = false),
            @ApiImplicitParam(name = "delted", value = "逻辑删除，非必须", required = false)
    })
    @PutMapping("/issue/{id}")
    @ApiOperation("修改常见问题表,传一个常见问题表的id过来")
    public Object issueUpdate(@PathVariable("id") int id,IssueEntity issueEntity){
        return issueService.issueUpdate(id,issueEntity);
    }






    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", value = "id，必须", required = true)
    })
    @DeleteMapping("/issue/{id}")
    @ApiOperation("删除常见问题表")
    public Object issueDelete(@PathVariable("id") int id){
        return issueService.issueDelete(id);
    }


}