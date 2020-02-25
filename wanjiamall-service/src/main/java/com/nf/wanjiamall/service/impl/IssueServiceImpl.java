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
    public List<IssueEntity> issueEntities(int pageNum, int pageSize) {
        List<IssueEntity> issueEntities = issueDao.issueEntities(pageNum, pageSize);
        for (IssueEntity issueEntity : issueEntities) {
            log.debug("值"+issueEntities);
        }
        return issueEntities;
    }

    @Override
    public IssueEntity getById(int id) {
        return issueDao.getById(id);
    }


    @Override
    public void insert(IssueEntity issueEntity){
        issueDao.insert(issueEntity);
    }

    @Override
    public boolean update(IssueEntity issueEntity) {
        return issueDao.update(issueEntity) > 0 ? true:false;

    }

    @Override
    public void delete(int id) {
        issueDao.delete(id);
    }

}
