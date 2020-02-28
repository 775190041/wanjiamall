package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.KeywordEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
 */
public interface KeywordDao {
    List<KeywordEntity> getKeywordList(@Param("pageNum") int pageNum,
                                       @Param("pageSize") int pageSize,
                                       @Param("keyword") String keyword);
    int keywordInsert(@Param("keywordEntity") KeywordEntity keywordEntity);
    int keywordUpdate(@Param("id") int id,KeywordEntity keywordEntity);
    int keywordDelete(int id);
}
