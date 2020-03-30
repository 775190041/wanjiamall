package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.LogDao;
import com.nf.wanjiamall.entity.LogEntity;
import com.nf.wanjiamall.service.LogService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LogServiceImpl implements LogService {

    @Autowired(required = false)
    private LogDao logDao;

    @Override
    public Object logInsert(LogEntity logEntity) {
        if (logDao.logInsert(logEntity) > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"添加失败");
        }
    }

    @Override
    public Object getLogList(Integer pageNum, Integer pageSize, String name) {
        return ResponseUtil.okList(logDao.getLogList(pageNum,pageSize,name));
    }

    @Override
    public Object logDelete(Integer id) {
        if (logDao.logDelete(id) > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"删除失败");
        }

    }
}
