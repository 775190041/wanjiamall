package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.CollectDao;
import com.nf.wanjiamall.dao.FootprintDao;
import com.nf.wanjiamall.entity.CollectEntity;
import com.nf.wanjiamall.entity.FootprintEntity;
import com.nf.wanjiamall.service.CollectService;
import com.nf.wanjiamall.service.FootprintService;
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
public class FootprintServiceImpl implements FootprintService {
    @Autowired
    private FootprintDao footprintDao;
    @Override
    public Object getFootprintList(Integer pageNum, Integer pageSize, FootprintEntity footprintEntity) {
        List<FootprintEntity> footprintEntities = footprintDao.getFootprintList(pageNum, pageSize, footprintEntity);
        return ResponseUtil.okList(footprintEntities);
    }
}
