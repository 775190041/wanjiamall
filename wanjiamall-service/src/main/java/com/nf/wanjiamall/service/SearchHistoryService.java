package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.SearchHistoryEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author 南八
 */
public interface SearchHistoryService {
   Object getSearchHistoryList(int pageNum, int pageSize, SearchHistoryEntity searchHistoryEntity);
}
