package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.TopicDao;
import com.nf.wanjiamall.entity.TopicEntity;
import com.nf.wanjiamall.service.TopicService;
import com.nf.wanjiamall.utils.ArrayUtils;
import com.nf.wanjiamall.utils.ResponseUtil;
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
    public Object getTopicAll(Integer pageNum, Integer pageSize, TopicEntity topicEntity) {
        return ResponseUtil.okList(topicDao.getTopicAll(pageNum,pageSize,topicEntity));
    }

    @Override
    public Object insertTopic(TopicEntity topicEntity) {
        String  goods = ArrayUtils.addDouble(topicEntity.getGoods());
        topicEntity.setGoodes(goods);
        Integer count = topicDao.insertTopic(topicEntity);
        if (count>0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"添加失败！");
        }
    }

    @Override
    public Object updateTopic(TopicEntity topicEntity, Integer id) {
        String  goods = ArrayUtils.addDouble(topicEntity.getGoods());
        topicEntity.setGoodes(goods);
        Integer count = topicDao.updateTopic(topicEntity,id);
        if (count>0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"修改失败！");
        }
    }

    @Override
    public Object deleteTopicId(Integer id) {
        Integer count = topicDao.deleteTopicId(id);
        if (count>0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"删除失败！");
        }
    }

    @Override
    public Object deleteTopicBatchId(Integer[] id) {
        Integer count = topicDao.deleteTopicBatchId(id);
        if (count>0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"删除失败！");
        }
    }


}
