package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.IssueEntity;
import com.nf.wanjiamall.service.impl.IssueServiceImpl;
import com.nf.wanjiamall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

   @ApiOperation("查询常见问题表")
   @GetMapping("/issue/{pageNum}-{pageSize}")
   public ResponseVo getIssueList(@PathVariable(required = false) int pageNum,
                               @PathVariable(required = false) int pageSize){
       List<IssueEntity> issueEntityList = issueService.getIssueList(pageNum, pageSize);
       ResponseVo responseVo = new ResponseVo(1,"查询成功",issueEntityList);
       return responseVo;
   }
//    @ApiOperation("按question模糊查询常见问题表")
//    @GetMapping("/issue")
//    public ResponseVo getByQuestion(String question){
//        List<IssueEntity> issueEntityList = issueService.getByQuestion(question);
//        ResponseVo responseVo = new ResponseVo(1,"查询成功",issueEntityList);
//        return responseVo;
//    }
    @PostMapping("/issue")
    @ApiOperation("添加常见问题表")
    public ResponseVo issueInsert(IssueEntity issueEntity) throws ParseException {
       boolean result = issueService.issueInsert(issueEntity);
       if(result != false){
           return new ResponseVo(1,"添加成功",true);
       }else {
           return new ResponseVo(0,"添加失败",false);
       }
    }


    @PutMapping("/issue/{id}")
    @ApiOperation("修改常见问题表,传一个常见问题表的id过来")
    public ResponseVo issueUpdate(@PathVariable("id") int id,IssueEntity issueEntity){
        boolean result = issueService.issueUpdate(id,issueEntity);
        if(result != false){
            return new ResponseVo(1,"修改成功",true);
        }else {
            return new ResponseVo(0,"修改失败",false);
        }

    }




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