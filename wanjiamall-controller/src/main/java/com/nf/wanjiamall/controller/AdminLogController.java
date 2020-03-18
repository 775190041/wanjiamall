package com.nf.wanjiamall.controller;


import com.nf.wanjiamall.service.LogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdminLogController {


    @Autowired
    private LogService logService;
    @GetMapping("/log/{pageNum}/{pageSize}")
    public Object getKeywordList(@PathVariable(required = false) int pageNum,
                                 @PathVariable(required = false) int pageSize,
                                 @RequestParam(value = "name",required = false,defaultValue = "") String name){
        return logService.getLogList(pageNum,pageSize,name);
    }


    @DeleteMapping("/log/{id}")
    public Object keywordDelete(@PathVariable("id") int id){

        return logService.logDelete(id);
    }
}
