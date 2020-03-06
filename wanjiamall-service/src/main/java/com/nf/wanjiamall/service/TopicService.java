package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.TopicEntity;

/**
 * @author lrc
 */

public interface TopicService {
    Object getTopicAll(Integer pageNum, Integer pageSize, TopicEntity topicEntity);


    Object insertTopic(TopicEntity topicEntity);

    Object updateTopic(TopicEntity topicEntity, Integer id);

    Object deleteTopicId(Integer id);

    Object deleteTopicBatchId(Integer[] id);
}
