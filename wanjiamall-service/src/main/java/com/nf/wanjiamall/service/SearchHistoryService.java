package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.SearchHistoryEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author 南八
 */
public interface SearchHistoryService {
   Object getSearchHistoryList(Integer pageNum, Integer pageSize, SearchHistoryEntity searchHistoryEntity);
   Object getSearchHistoryByUserId(Integer pageNum, Integer pageSize,Integer userId);
   Object searchHistoryDelete(Integer userId);
}
