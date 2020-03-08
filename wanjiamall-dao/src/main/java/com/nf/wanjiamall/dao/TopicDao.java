package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.TopicEntity;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author lrc
 */

public interface TopicDao {
    List<TopicEntity> getAll();

    List<TopicEntity> getTopicAll(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize,@Param("topic")TopicEntity topicEntity);

    TopicEntity getById(@Param("id")Integer id);

    Integer insertTopic(@Param("topic")TopicEntity topicEntity);

    Integer updateTopic(@Param("topic")TopicEntity topicEntity,@Param("id")Integer id);

    Integer deleteTopicId(@Param("id")Integer id);

    Integer deleteTopicBatchId(Integer[] id);


}
