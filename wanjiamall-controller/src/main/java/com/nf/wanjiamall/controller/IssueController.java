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
   public ResponseVo issueList(@PathVariable(required = false) int pageNum,
                               @PathVariable(required = false) int pageSize){
       List<IssueEntity> issueEntityList = issueService.issueEntities(pageNum, pageSize);
       ResponseVo responseVo = new ResponseVo(1,"查询成功",issueEntityList);
       return responseVo;
   }
    @ApiOperation("按id查询常见问题表")
    @GetMapping("/issue")
    public ResponseVo issueById(int id){
        IssueEntity issueEntity = issueService.getById(id);
        ResponseVo responseVo = new ResponseVo(1,"查询成功",issueEntity);
        return responseVo;
    }
    @PostMapping("/issue")
    @ApiOperation("添加常见问题表")
    public ResponseVo issueInsert(IssueEntity issueEntity) throws ParseException {
       /* issueEntity.setQuestion("111");
        issueEntity.setAnswer("222");
        issueEntity.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-02-25"));
        issueEntity.setAddTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-02-20"));*/
        issueService.insert(issueEntity);
        return new ResponseVo(1,"添加成功",true);
    }


    @PutMapping("/issue")
    @ApiOperation("修改常见问题表,传一个常见问题表的id过来")
    public ResponseVo issueUpdate(IssueEntity issueEntity){
        boolean bool = issueService.update(issueEntity);
        return new ResponseVo(1,"修改成功",true);
    }




    @DeleteMapping("/issue")
    @ApiOperation("删除常见问题表")
    public ResponseVo issueDelete(int id){
       issueService.delete(id);
       return new ResponseVo(1,"删除成功",true);
    }


}