package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.KeywordEntity;
import com.nf.wanjiamall.service.impl.KeywordServiceImpl;
import com.nf.wanjiamall.vo.ResponseVo;
import io.swagger.annotations.Api;
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

    @ApiOperation("查询关键字表")
    @GetMapping("/keyword/{pageNum}-{pageSize}")
    public ResponseVo getKeywordList(@PathVariable(required = false) int pageNum,
                                @PathVariable(required = false) int pageSize){
        List<KeywordEntity> keywordEntityList = keywordService.getKeywordList(pageNum, pageSize);
        ResponseVo responseVo = new ResponseVo(1,"查询成功",keywordEntityList);
        return responseVo;
    }
    @ApiOperation("按关键字(keyword)查询关键字表")
    @GetMapping("/keyword")
    public ResponseVo getByKeyword(String keyword){
        KeywordEntity keywordEntity = keywordService.getByKeyword(keyword);
        ResponseVo responseVo = new ResponseVo(1,"查询成功",keywordEntity);
        return responseVo;
    }
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


    @PutMapping("/keyword")
    @ApiOperation("修改关键字表,传一个关键字表的id过来")
    public ResponseVo keywordUpdate(KeywordEntity keywordEntity){
        boolean result = keywordService.keywordUpdate(keywordEntity);
        if(result != false){
            return new ResponseVo(1,"修改成功",true);
        }else {
            return new ResponseVo(0,"修改失败",false);
        }

    }

    @DeleteMapping("/keyword")
    @ApiOperation("删除常见问题表")
    public ResponseVo keywordDelete(int id){
        boolean result = keywordService.keywordDelete(id);
        if (result != false){
            return new ResponseVo(1,"删除成功",true);
        }
        else {
            return new ResponseVo(0,"删除失败",false);
        }
    }

}
