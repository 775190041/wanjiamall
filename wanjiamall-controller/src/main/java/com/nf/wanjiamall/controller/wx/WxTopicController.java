package com.nf.wanjiamall.controller.wx;


import com.nf.wanjiamall.entity.TopicEntity;
import com.nf.wanjiamall.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lrc
 */
@RestController
@Api(tags = "专题精选")
@RequestMapping("/wx")
public class WxTopicController {

    @Autowired
    private TopicService topicService;

    @ApiOperation("查询专题所有数据")
    @GetMapping("/topic")
    public Object getTopicAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                              @RequestParam(name = "pageSize",required = false,defaultValue = "10")Integer pageSize, TopicEntity topicEntity){
        return topicService.getTopicAll(pageNum, pageSize,topicEntity);
    }

    @ApiOperation("查询某个专题的数据")
    @GetMapping("/topic/{id}")
    public Object getTopicById(@PathVariable Integer id){
        return topicService.getById(id);
    }
}
