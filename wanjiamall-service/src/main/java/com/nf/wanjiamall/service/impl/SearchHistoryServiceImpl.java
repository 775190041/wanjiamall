package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.SearchHistoryDao;
import com.nf.wanjiamall.entity.SearchHistoryEntity;
import com.nf.wanjiamall.service.SearchHistoryService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 南八
 */
@Service
@Slf4j
public class SearchHistoryServiceImpl implements SearchHistoryService {

    @Autowired
    private SearchHistoryDao searchHistoryDao;
    @Override
    public Object getSearchHistoryList(Integer pageNum, Integer pageSize,SearchHistoryEntity searchHistoryEntity) {
        List<SearchHistoryEntity> searchHistoryEntities = searchHistoryDao.getSearchHistoryList(pageNum, pageSize, searchHistoryEntity);
        return ResponseUtil.okList(searchHistoryEntities);
    }
}
