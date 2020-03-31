package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.IssueEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
        */
public interface IssueDao {
    List<IssueEntity> getIssueList(@Param("pageNum") int pageNum,
                                   @Param("pageSize") int pageSize,
                                   @Param("question") String question);
    int issueInsert(@Param("issueEntity") IssueEntity issueEntity);
    int issueUpdate(@Param("id") int id,IssueEntity issueEntity);
    int issueDelete(int id);

    List<IssueEntity> getAll();
}
