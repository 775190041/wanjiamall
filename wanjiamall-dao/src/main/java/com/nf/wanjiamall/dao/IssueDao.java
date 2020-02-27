package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.IssueEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
        */
public interface IssueDao {
    List<IssueEntity> getIssueList(@Param("pageNum") int pageNum,
                                    @Param("pageSize") int pageSize);
    List<IssueEntity> getByQuestion(String question);
    int issueInsert(IssueEntity issueEntity);
    int issueUpdate(@Param("id") int id,IssueEntity issueEntity);
    int issueDelete(int id);
}
