package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.KeywordEntity;
import com.nf.wanjiamall.service.impl.KeywordServiceImpl;
import com.nf.wanjiamall.vo.ResponseVo;
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
public class KeywordController {
    @Autowired
    private KeywordServiceImpl keywordService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer", value = "当前页码，必须", required = false),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "分页大小，必须", required = false),
            @ApiImplicitParam(name = "keyword", dataType = "String", value = "关键字，非必须", required = false)

    })
    @ApiOperation("查询关键字表")
    @GetMapping("/keyword/{pageNum}-{pageSize}")
    public ResponseVo getKeywordList(@PathVariable(required = false) int pageNum,
                                     @PathVariable(required = false) int pageSize,
                                     @RequestParam(value = "keyword",required = false,defaultValue = "") String keyword){
        List<KeywordEntity> keywordEntityList = keywordService.getKeywordList(pageNum, pageSize,keyword);
        ResponseVo responseVo = new ResponseVo(1,"查询成功",keywordEntityList);
        return responseVo;
    }



    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", dataType = "String", value = "关键字，非必须", required = false),
            @ApiImplicitParam(name = "url", dataType = "String", value = "关键字跳转地址，非必须", required = false),
            @ApiImplicitParam(name = "is_not", dataType = "String", value = "是否为热门关键字，非必须", required = false),
            @ApiImplicitParam(name = "add_time", dataType = "Timestamp", value = "创建时间，非必须", required = false),
            @ApiImplicitParam(name = "update_time", dataType = "Timestamp", value = "修改时间，非必须", required = false),
            @ApiImplicitParam(name = "delted", value = "逻辑删除，非必须", required = false)
    })
    @PostMapping("/keyword")
    @ApiOperation("添加关键字表")
    public ResponseVo keywordInsert(KeywordEntity keywordEntity) throws ParseException {
        boolean result = keywordService.keywordInsert(keywordEntity);
        if(result != false){
            return new ResponseVo(1,"添加成功",true);
        }else {
            return new ResponseVo(0,"添加失败",false);
        }
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
    public ResponseVo keywordUpdate(@PathVariable("id") int id,KeywordEntity keywordEntity){
        boolean result = keywordService.keywordUpdate(id,keywordEntity);
        if(result != false){
            return new ResponseVo(1,"修改成功",true);
        }else {
            return new ResponseVo(0,"修改失败",false);
        }

    }



    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", value = "id，必须", required = true)
    })
    @DeleteMapping("/keyword/{id}")
    @ApiOperation("删除常见问题表")
    public ResponseVo keywordDelete(@PathVariable("id") int id){
        boolean result = keywordService.keywordDelete(id);
        if (result != false){
            return new ResponseVo(1,"删除成功",true);
        }
        else {
            return new ResponseVo(0,"删除失败",false);
        }
    }

}
