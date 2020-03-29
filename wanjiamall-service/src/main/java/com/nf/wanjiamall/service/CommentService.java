package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.CommentEntity;

/**
 * 评论服务
 */
public interface CommentService {

    /**
     * 分页查询评论数据
     */
    Object getCommentAll(Integer pageNum , Integer pageSize, CommentEntity commentEntity);

    /**
     * 删除评论信息
     */
    Object deleteCommentId(Integer commentId);


}
