package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.KeywordEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
 */
public interface KeywordService {
    Object getKeywordList(int pageNum,int pageSize,String keyword);
    Object keywordInsert(KeywordEntity keywordEntity);
    Object keywordUpdate(int id,KeywordEntity keywordEntity);
    Object keywordDelete(int id);
}
