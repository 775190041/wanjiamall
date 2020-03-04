package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.SystemDao;
import com.nf.wanjiamall.entity.SystemEntity;
import com.nf.wanjiamall.service.SystemService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemDao systemDao;

    @Override
    public Object selectByFreightValue() {
        return null;
    }

    @Override
    public Object updateFreight(int id, SystemEntity systemEntity) {
               log.info("systemEntity = " + systemEntity.getKeyValue());
        if (systemDao.updateFreight(id, systemEntity) > 0) {
            log.info("ok------------------ = " + systemEntity.getKeyValue());
            return ResponseUtil.ok();
        } else {
            log.info("bok------------------ = " + systemEntity.getKeyValue());
            return ResponseUtil.fail(505, "修改失败");
        }

    }

    @Override
    public Object selectByOrderValue() {
        return null;
    }

    @Override
    public Object updateOrder(int id, SystemEntity systemEntity) {
        if(systemDao.updateOrder(id,systemEntity) > 0){
            return  ResponseUtil.ok();
        }else{
            return  ResponseUtil.fail(505,"修改失败");
        }
    }

    @Override
    public Object selectByAppletValue() {
        return null;
    }

    @Override
    public Object updateApplet(int id, SystemEntity systemEntity) {
        if(systemDao.updateApplet(id,systemEntity) > 0){
            return  ResponseUtil.ok();
        }else{
            return  ResponseUtil.fail(505,"修改失败");
        }
    }
}
