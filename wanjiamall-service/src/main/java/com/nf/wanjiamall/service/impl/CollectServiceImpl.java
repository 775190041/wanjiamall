package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.CollectDao;
import com.nf.wanjiamall.entity.CollectEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
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
}
