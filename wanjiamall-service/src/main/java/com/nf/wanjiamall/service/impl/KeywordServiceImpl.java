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
    public List<KeywordEntity> getKeywordList(int pageNum, int pageSize,String keyword) {
        List<KeywordEntity> keywordEntities = keywordDao.getKeywordList(pageNum, pageSize,keyword);
        for (KeywordEntity keywordEntity : keywordEntities) {
            log.debug("值"+keywordEntity);
        }
        return keywordEntities;
    }

    @Override
    public boolean keywordInsert(KeywordEntity keywordEntity) {
        return keywordDao.keywordInsert(keywordEntity) > 0 ? true:false;
    }

    @Override
    public boolean keywordUpdate(int id,KeywordEntity keywordEntity) {
        return keywordDao.keywordUpdate(id,keywordEntity) > 0 ? true:false;
    }

    @Override
    public boolean keywordDelete(int id) {
        return keywordDao.keywordDelete(id) > 0 ? true:false;
    }
}
