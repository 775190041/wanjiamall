package com.nf.wanjiamall.service.impl;


import com.nf.wanjiamall.dao.AdvertisingDao;
import com.nf.wanjiamall.entity.AdvertisingEntity;
import com.nf.wanjiamall.service.AdvertisingService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lrc
 */
@Slf4j
@Service
public class AdvertisingServiceImpl implements AdvertisingService {

    @Autowired
    private AdvertisingDao advertisingDao;
    @Override
    public Object getAll(Integer pageNum ,Integer pageSize) {
        List<AdvertisingEntity> list =  advertisingDao.getAll(pageNum,pageSize);
        return ResponseUtil.okList(list);
    }

    @Override
    public Object getByAd(Integer pageNum, Integer pageSize, String name, String content) {
        List<AdvertisingEntity> list =  advertisingDao.getByAd(pageNum,pageSize,name,content);
        return ResponseUtil.okList(list);
    }

    @Override
    public Object insertAd(AdvertisingEntity advertisingEntity) {
        advertisingDao.insertAd(advertisingEntity);
        return ResponseUtil.ok();

    }

    @Override
    public Object updateAd(AdvertisingEntity advertisingEntity, Integer id) {
        if (advertisingDao.updateAd(advertisingEntity,id)>0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"删除失败");
        }
    }

    @Override
    public Object deletedAdId(Integer id) {


        advertisingDao.deletedAdId(id);
        return ResponseUtil.ok();
    }

}
