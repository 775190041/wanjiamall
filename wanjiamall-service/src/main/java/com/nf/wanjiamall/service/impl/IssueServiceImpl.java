package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.IssueDao;
import com.nf.wanjiamall.entity.IssueEntity;
import com.nf.wanjiamall.service.IssueService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 南八
 */
@Service
@Slf4j
public class IssueServiceImpl implements IssueService {
    @Autowired
    private IssueDao issueDao;

    @Override
    public Object getIssueList(int pageNum, int pageSize,String question) {
        List<IssueEntity> issueEntities = issueDao.getIssueList(pageNum, pageSize,question);
        return ResponseUtil.okList(issueEntities);
    }



    @Override
    public Object issueInsert(IssueEntity issueEntity){
        if (issueDao.issueInsert(issueEntity) > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"添加失败");
        }
    }

    @Override
    public Object issueUpdate(int id,IssueEntity issueEntity) {
        if (issueDao.issueUpdate(id, issueEntity) > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"修改失败");
        }

    }

    @Override
    public Object issueDelete(int id) {
        if (issueDao.issueDelete(id) > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"删除失败");
        }

    }

}
