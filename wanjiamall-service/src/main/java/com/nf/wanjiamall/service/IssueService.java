package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.IssueEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
 */
public interface IssueService {
    List<IssueEntity> getIssueList(int pageNum, int pageSize,String question);
    boolean issueInsert(IssueEntity issueEntity);
    boolean issueUpdate(int id,IssueEntity issueEntity);
    boolean issueDelete(int id);
}
