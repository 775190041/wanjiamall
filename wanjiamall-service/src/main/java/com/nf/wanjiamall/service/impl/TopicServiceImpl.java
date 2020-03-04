package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.TopicDao;
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
    public Object getAll(Integer pageNum, Integer pageSize) {
        return topicDao.getAll(pageNum,pageSize);
    }

    @Override
    public Object getByTopic(Integer pageNum, Integer pageSize, String title, String subtitle, Integer sort) {
        return topicDao.getByTopic(pageNum,pageSize,title,subtitle,sort);
    }
}
