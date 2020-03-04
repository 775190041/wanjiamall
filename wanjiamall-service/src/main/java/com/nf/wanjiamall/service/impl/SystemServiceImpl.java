package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.SystemDao;
import com.nf.wanjiamall.entity.SystemEntity;
import com.nf.wanjiamall.service.SystemService;
import com.nf.wanjiamall.utils.JacksonUtil;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemDao systemDao;

    @Override
    public Object selectValue() {
        return systemDao.selectValue();
    }

    @Override
    public Object updateFreight(String  systemFreight) {
        System.err.println("systemFreight = " + systemFreight);
        Map<String,String> map = JacksonUtil.toMap(systemFreight);
        int row = 0;
            for (Map.Entry<String, String> entry: map.entrySet()) {
                String string = entry.getValue();
                if(string instanceof String) {
                    SystemEntity systemEntity = new SystemEntity();
                    systemEntity.setKeyName(entry.getKey());
                    systemEntity.setKeyValue(entry.getValue());
                    systemEntity.setUpdateTime(new Date());
                    System.err.println("systemEntity = " + systemEntity);
                    row = systemDao.updateFreight(systemEntity);
                } else {
                    updateFreight(string);
                }
            }
        System.out.println("row = " + row);
        if(row > 0){
            return ResponseUtil.ok();
        }else{
            return ResponseUtil.fail(505,"添加失败");
        }
    }

/*
                    SystemEntity systemEntity = new SystemEntity();
                    systemEntity.setKeyName(entry.getKey());
                    systemEntity.setKeyValue(entry.getValue().toString());
                    systemEntity.setUpdateTime(new Date());
                    System.err.println("systemEntity = " + systemEntity);
                    row = systemDao.updateFreight(systemEntity);
 */

    @Override
    public Object selectByOrderValue() {
        return null;
    }

    @Override
    public Object updateOrder(SystemEntity systemOrder) {
        return null;
    }

    @Override
    public Object selectByAppletValue() {
        return null;
    }

    @Override
    public Object updateApplet(SystemEntity systemApplet) {
        return null;
    }
}
