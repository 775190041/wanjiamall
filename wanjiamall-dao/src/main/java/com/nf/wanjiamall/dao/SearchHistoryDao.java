package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.SearchHistoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
 */
public interface SearchHistoryDao {
    List<SearchHistoryEntity> getSearchHistoryList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                                                   @Param("searchHistory") SearchHistoryEntity searchHistoryEntity);
    List<SearchHistoryEntity> getSearchHistoryByUserId(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                                                   @Param("userId") Integer userId);
    int searchHistoryDelete(Integer userId);
}
