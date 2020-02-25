package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.IssueEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
 */
public interface IssueService {
    List<IssueEntity> issueEntities(int pageNum, int pageSize);
    IssueEntity getById(int id);
    boolean insert(IssueEntity issueEntity);
    boolean update(IssueEntity issueEntity);
    boolean delete(int id);
}
