package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.KeywordEntity;

import java.util.List;

/**
 * @author 南八
 */
public interface KeywordService {
    List<KeywordEntity> getKeywordList(int pageNum,int pageSize,String keyword);
    boolean keywordInsert(KeywordEntity keywordEntity);
    boolean keywordUpdate(int id,KeywordEntity keywordEntity);
    boolean keywordDelete(int id);
}
