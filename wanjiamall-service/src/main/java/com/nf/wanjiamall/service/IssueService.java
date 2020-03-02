package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.IssueEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
 */
public interface IssueService {
    Object getIssueList(int pageNum, int pageSize,String question);
    Object issueInsert(IssueEntity issueEntity);
    Object issueUpdate(int id,IssueEntity issueEntity);
    Object issueDelete(int id);
}
