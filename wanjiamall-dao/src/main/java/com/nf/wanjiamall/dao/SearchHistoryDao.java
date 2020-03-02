package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.SearchHistoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
 */
public interface SearchHistoryDao {
    List<SearchHistoryEntity> getSearchHistoryList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize,
                                                   @Param("searchHistory") SearchHistoryEntity searchHistoryEntity);
}
