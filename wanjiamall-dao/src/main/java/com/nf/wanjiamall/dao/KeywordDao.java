package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.KeywordEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
 */
public interface KeywordDao {
    List<KeywordEntity> getKeywordList(@Param("pageNum") int pageNum,
                                      @Param("pageSize") int pageSize);
    KeywordEntity getByKeyword(String keyword);
    int keywordInsert(KeywordEntity issueEntity);
    int keywordUpdate(KeywordEntity issueEntity);
    int keywordDelete(int id);
}
