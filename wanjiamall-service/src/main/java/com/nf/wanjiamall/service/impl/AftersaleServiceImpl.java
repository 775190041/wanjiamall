package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.AftersaleDao;
import com.nf.wanjiamall.service.AftersaleService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AftersaleServiceImpl implements AftersaleService {
    @Autowired(required = false)
    private AftersaleDao aftersaleDao;

    @Override
    public Object getAftersaleList(Integer pageNum,
                                   Integer pageSize,
                                   String aftersaleSn,
                                   Integer orderId,
                                   Integer status) {
        return ResponseUtil.okList(aftersaleDao.getAftersaleList(pageNum,pageSize,aftersaleSn,orderId,status));
    }
}
