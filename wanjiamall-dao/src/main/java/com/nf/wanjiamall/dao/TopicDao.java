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

}
