package com.nf.wanjiamall.controller;

import com.github.pagehelper.PageInfo;
import com.nf.wanjiamall.entity.IssueEntity;
import com.nf.wanjiamall.service.impl.IssueServiceImpl;
import com.nf.wanjiamall.vo.ResponseVo;
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
public class IssueController {

    @Autowired
    private IssueServiceImpl issueService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前页码，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "分页大小，必须", required = false),
            @ApiImplicitParam(name = "question", dataType = "String", value = "问题标题，非必须", required = false)

    })

   @ApiOperation("查询常见问题表")
   @GetMapping("/issue/{pageNum}-{pageSize}")
   public ResponseVo getIssueList(@PathVariable(required = false) int pageNum,
                                  @PathVariable(required = false) int pageSize,
                                  @RequestParam(value = "question",required = false,defaultValue = "") String question){
       List<IssueEntity> issueEntityList = issueService.getIssueList(pageNum, pageSize,question);
        PageInfo<IssueEntity> pageInfo = new PageInfo<>(issueEntityList,pageSize);
       ResponseVo responseVo = new ResponseVo(1,"查询成功",pageInfo);
       return responseVo;
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
    public ResponseVo issueInsert(IssueEntity issueEntity) {
       boolean result = issueService.issueInsert(issueEntity);
       if(result != false){
           return new ResponseVo(1,"添加成功",true);
       }else {
           return new ResponseVo(0,"添加失败",false);
       }
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
    public ResponseVo issueUpdate(@PathVariable("id") int id,IssueEntity issueEntity){
        System.out.println("============"+issueEntity);
        boolean result = issueService.issueUpdate(id,issueEntity);
        if(result != false){
            return new ResponseVo(1,"修改成功",true);
        }else {
            return new ResponseVo(0,"修改失败",false);
        }

    }



    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", value = "id，必须", required = true)
    })
    @DeleteMapping("/issue/{id}")
    @ApiOperation("删除常见问题表")
    public ResponseVo issueDelete(@PathVariable("id") int id){
       boolean result = issueService.issueDelete(id);
       if (result != false){
           return new ResponseVo(1,"删除成功",true);
       }
       else {
           return new ResponseVo(0,"删除失败",false);
       }
    }


}