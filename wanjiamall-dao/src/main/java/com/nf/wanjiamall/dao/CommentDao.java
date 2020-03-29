package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.CommentEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论dao
 */
public interface CommentDao {

    /**
     * 分页查询评论数据
     */
    List<CommentEntity> getCommentAll(@Param("pageNum") Integer pageNum,
                                      @Param("pageSize")Integer pageSize,
                                      @Param("CommentEntity") CommentEntity commentEntity);

    /**
     * 删除评论信息
     */
    int deleteCommentId(@Param("commentId")Integer commentId);
}
