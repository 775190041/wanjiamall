package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.CollectDao;
import com.nf.wanjiamall.entity.CollectEntity;
import com.nf.wanjiamall.service.CollectService;
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
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectDao collectDao;
    @Override
    public Object getCollectList(Integer pageNum, Integer pageSize, CollectEntity collectEntity) {
        List<CollectEntity> collectEntities = collectDao.getCollectList(pageNum, pageSize, collectEntity);
        return ResponseUtil.okList(collectEntities);
    }

    @Override
    public Object getCollectByUserId(Integer pageNum, Integer pageSize, Integer userId) {
        List<CollectEntity> collectEntities = collectDao.getCollectByUserId(pageNum, pageSize, userId);
        return ResponseUtil.okList(collectEntities);
    }

    @Override
    public Object getCollectInsertAndDelete(Integer userId,Integer goodsId) {
        if(collectDao.getCollectInsertAndDelete(userId,goodsId) == null){
            return  ResponseUtil.ok(collectDao.collectInsert(userId,goodsId));
        }
        else {
            return ResponseUtil.ok(collectDao.collectDelete(userId,goodsId));
        }

    }


    @Override
    public Object collectInsert(Integer userId,Integer goodsId) {
        if (collectDao.collectInsert(userId,goodsId) > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"添加失败");
        }
    }

    @Override
    public Object collectDelete( Integer userId,Integer goodsId) {
        if (collectDao.collectDelete(userId,goodsId) > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"删除失败");
        }
    }

}
