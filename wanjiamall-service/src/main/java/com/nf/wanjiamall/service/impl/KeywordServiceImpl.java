package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.KeywordDao;
import com.nf.wanjiamall.entity.KeywordEntity;
import com.nf.wanjiamall.service.KeywordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 南八
 */
@Service
@Slf4j
public class KeywordServiceImpl implements KeywordService {
    @Autowired
    private KeywordDao keywordDao;
    @Override
    public List<KeywordEntity> getKeywordList(int pageNum, int pageSize) {
        List<KeywordEntity> keywordEntities = keywordDao.getKeywordList(pageNum, pageSize);
        for (KeywordEntity keywordEntity : keywordEntities) {
            log.debug("值"+keywordEntity);
        }
        return keywordEntities;
    }

    @Override
    public KeywordEntity getByKeyword(String keyword) {
        return keywordDao.getByKeyword(keyword);
    }

    @Override
    public boolean keywordInsert(KeywordEntity issueEntity) {
        return keywordDao.keywordInsert(issueEntity) > 0 ? true:false;
    }

    @Override
    public boolean keywordUpdate(KeywordEntity issueEntity) {
        return keywordDao.keywordUpdate(issueEntity) > 0 ? true:false;
    }

    @Override
    public boolean keywordDelete(int id) {
        return keywordDao.keywordDelete(id) > 0 ? true:false;
    }
}
