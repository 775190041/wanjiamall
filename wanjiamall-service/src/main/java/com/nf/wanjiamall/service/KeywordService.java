package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.KeywordEntity;

import java.util.List;

/**
 * @author 南八
 */
public interface KeywordService {
    List<KeywordEntity> getKeywordList(int pageNum,int pageSize);
    KeywordEntity getByKeyword(String keyword);
    boolean keywordInsert(KeywordEntity issueEntity);
    boolean keywordUpdate(KeywordEntity issueEntity);
    boolean keywordDelete(int id);
}
