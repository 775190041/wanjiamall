package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.CommentDao;
import com.nf.wanjiamall.entity.CommentEntity;
import com.nf.wanjiamall.service.CommentService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Object getCommentAll(Integer pageNum, Integer pageSize, CommentEntity commentEntity) {
        List<CommentEntity> list = commentDao.getCommentAll(pageNum, pageSize, commentEntity);
        return ResponseUtil.ok(list);
    }

    @Override
    public Object deleteCommentId(Integer commentId) {
        if (commentDao.deleteCommentId(commentId) > 0 ){
            return ResponseUtil.ok();
        }else{
            return ResponseUtil.fail(505,"删除失败");
        }
    }
}
