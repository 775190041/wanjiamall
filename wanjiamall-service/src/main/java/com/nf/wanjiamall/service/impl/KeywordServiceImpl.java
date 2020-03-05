package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.KeywordDao;
import com.nf.wanjiamall.entity.KeywordEntity;
import com.nf.wanjiamall.service.KeywordService;
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
public class KeywordServiceImpl implements KeywordService {
    @Autowired
    private KeywordDao keywordDao;
    @Override
    public Object getKeywordList(int pageNum, int pageSize,String keyword) {
        List<KeywordEntity> keywordEntities = keywordDao.getKeywordList(pageNum, pageSize,keyword);
        return ResponseUtil.okList(keywordEntities);
    }



    @Override
    public Object keywordInsert(KeywordEntity keywordEntity) {
        if (keywordDao.keywordInsert(keywordEntity) > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"添加失败");
        }

    }

    @Override
    public Object keywordUpdate(int id,KeywordEntity keywordEntity) {
        if (keywordDao.keywordUpdate(id,keywordEntity) > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"修改失败");
        }
    }

    @Override
    public Object keywordDelete(int id) {
        if (keywordDao.keywordDelete(id) > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"删除失败");
        }

    }
}
