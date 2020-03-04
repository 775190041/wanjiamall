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
        Map<String,String> map = JacksonUtil.toMap(systemFreight);
        int row = 0;
            for (Map.Entry<String, String> entry: map.entrySet()) {
                String string = entry.getValue();
                if(string instanceof String) {
                    SystemEntity systemEntity = new SystemEntity();
                    systemEntity.setKeyName(entry.getKey());
                    systemEntity.setKeyValue(entry.getValue());
                    systemEntity.setUpdateTime(new Date());
                    row = systemDao.updateAll(systemEntity);
                } else {
                    updateFreight(string);
                }
            }
        if(row > 0){
            return ResponseUtil.ok();
        }else{
            return ResponseUtil.fail(505,"修改失败");
        }
    }
}
