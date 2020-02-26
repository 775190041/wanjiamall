package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.IssueDao;
import com.nf.wanjiamall.entity.IssueEntity;
import com.nf.wanjiamall.service.IssueService;
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
    public List<IssueEntity> getIssueList(int pageNum, int pageSize) {
        List<IssueEntity> issueEntities = issueDao.getIssueList(pageNum, pageSize);
        for (IssueEntity issueEntity : issueEntities) {
            log.debug("值"+issueEntity);
        }
        return issueEntities;
    }

    @Override
    public IssueEntity getById(int id) {
        return issueDao.getById(id);
    }


    @Override
    public boolean issueInsert(IssueEntity issueEntity){
        return issueDao.issueInsert(issueEntity) > 0 ? true:false;
    }

    @Override
    public boolean issueUpdate(IssueEntity issueEntity) {
        return issueDao.issueUpdate(issueEntity) > 0 ? true:false;
    }

    @Override
    public boolean issueDelete(int id) {
        return issueDao.issueDelete(id) > 0 ? true:false;
    }

}
