package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.TopicDao;
import com.nf.wanjiamall.entity.TopicEntity;
import com.nf.wanjiamall.service.TopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lrc
 */
@Slf4j
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDao topicDao;

    @Override
    public Object getAll(Integer pageNum, Integer pageSize, TopicEntity topicEntity) {
        return topicDao.getAll(pageNum,pageSize,topicEntity);
    }


}
