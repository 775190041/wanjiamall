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
    public List<IssueEntity> getByQuestion(String question) {
        return issueDao.getByQuestion(question);
    }

  /*  @Override
    public IssueEntity getByQuestion(String question) {
        return issueDao.getByQuestion(question);
    }
*/

    @Override
    public boolean issueInsert(IssueEntity issueEntity){
        return issueDao.issueInsert(issueEntity) > 0 ? true:false;
    }

    @Override
    public boolean issueUpdate(int id,IssueEntity issueEntity) {
        return issueDao.issueUpdate(id,issueEntity) > 0 ? true:false;
    }

    @Override
    public boolean issueDelete(int id) {
        return issueDao.issueDelete(id) > 0 ? true:false;
    }

}
