package com.nf.wanjiamall.service.advertising.impl;


import com.nf.wanjiamall.dao.advertising.AdvertisingDao;
import com.nf.wanjiamall.entity.AdvertisingEntity;
import com.nf.wanjiamall.service.advertising.AdvertisingService;
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
    public void updateAd(AdvertisingEntity advertisingEntity, Integer id) {
        advertisingDao.updateAd(advertisingEntity,id);
    }

}
