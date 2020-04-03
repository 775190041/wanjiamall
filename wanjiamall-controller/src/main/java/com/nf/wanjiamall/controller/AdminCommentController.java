package com.nf.wanjiamall.controller;

import com.nf.wanjiamall.entity.CommentEntity;
import com.nf.wanjiamall.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "wanjia_comment")
@RequestMapping("/api")
public class AdminCommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation("分页查询评论信息")
    @GetMapping("/comment/{pageNum}/{pageSize}")
    public Object getCommentAll(@PathVariable("pageNum")Integer pageNum,
                                @PathVariable("pageSize") Integer pageSize,
                                CommentEntity commentEntity){

        return commentService.getCommentAll(pageNum, pageSize, commentEntity);
    }

    @ApiOperation("评论信息删除")
    @DeleteMapping("/comment/{commentId}")
    public Object deleteCommentId(@PathVariable("commentId")Integer commentId){
        return commentService.deleteCommentId(commentId);
    }

}
