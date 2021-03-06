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
    @Autowired(required = false)
    private AdvertisingDao advertisingDao;

    @Override
    public Object getAdAll(Integer pageNum ,Integer pageSize,AdvertisingEntity advertisingEntity) {
        return ResponseUtil.okList(advertisingDao.getAdAll(pageNum,pageSize,advertisingEntity));
    }

    @Override
    public Object insertAd(AdvertisingEntity advertisingEntity) {
        Integer count = advertisingDao.insertAd(advertisingEntity);
        if (count>0){
            return ResponseUtil.ok("添加成功");
        }else {
            return ResponseUtil.insertDataFailed();
        }
    }

    @Override
    public Object updateAd(AdvertisingEntity advertisingEntity, Integer id) {
        Integer count = advertisingDao.updateAd(advertisingEntity,id);
        if (count>0){
            return ResponseUtil.ok("修改成功");
        }else {
            return ResponseUtil.updateDataFailed();
        }
    }

    @Override
    public Object deletedAdId(Integer id) {
        Integer count = advertisingDao.deletedAdId(id);
        if (count>0){
            return ResponseUtil.ok("删除成功");
        }else {
            return ResponseUtil.deleteDataFailed();
        }
    }

}
