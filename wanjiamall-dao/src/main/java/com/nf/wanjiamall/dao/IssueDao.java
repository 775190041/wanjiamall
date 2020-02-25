package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.IssueEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
        */
public interface IssueDao {
    List<IssueEntity> issueEntities(@Param("pageNum") int pageNum,
                                    @Param("pageSize") int pageSize);
    IssueEntity getById(int id);
    int insert(IssueEntity issueEntity);
    int update(IssueEntity issueEntity);
    int delete(int id);
}
