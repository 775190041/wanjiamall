package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.RegionDao;
import com.nf.wanjiamall.entity.RegionEntity;
import com.nf.wanjiamall.service.wx.WxRegionService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 行政区域表 实现类
 */
@Service
@Slf4j
public class WxRegionServiceImpl implements WxRegionService {

   @Autowired
   private RegionDao regionDao;

    @Override
    public Object getRegionProvinceQuery() {
        return ResponseUtil.ok(regionDao.getRegionProvinceQuery());
    }

    @Override
    public Object getRegionPidCityQuery(Integer type, Integer pId) {
       return  ResponseUtil.ok(regionDao.getRegionPidCityQuery(type,pId));
    }
}
