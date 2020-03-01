package com.nf.wanjiamall.service.impl;


import com.nf.wanjiamall.dao.AdvertisingDao;
import com.nf.wanjiamall.entity.AdvertisingEntity;
import com.nf.wanjiamall.service.AdvertisingService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdvertisingServiceImpl implements AdvertisingService {

    @Autowired
    private AdvertisingDao advertisingDao;

    private static final Logger log = LoggerFactory.getLogger(AdvertisingServiceImpl.class);
    @Override
    public List<AdvertisingEntity> getAll(Integer pageNum ,Integer pageSize) {
        List<AdvertisingEntity> list =  advertisingDao.getAll(pageNum,pageSize);
        for (AdvertisingEntity advertisingEntity : list) {
            log.debug("值"+advertisingEntity);
        }
        return list;
    }

    @Override
    public void insertAd(AdvertisingEntity advertisingEntity) {
        advertisingDao.insertAd(advertisingEntity);
    }

    @Override
    public void updateAd(AdvertisingEntity advertisingEntity, Integer id) {
        advertisingDao.updateAd(advertisingEntity,id);
    }

    @Override
    public Integer deletedAdId(Integer id) {
        return advertisingDao.deletedAdId(id);
    }

}
