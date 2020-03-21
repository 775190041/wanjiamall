package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.AftersaleDao;
import com.nf.wanjiamall.service.AftersaleService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Object batchAudit(List<Integer> ids, Integer status) {
        if (ids.size()>0){
            for (Integer id : ids) {
                aftersaleDao.batchAudit(id,status);
            }
            return ResponseUtil.ok("批量修改成功");
        }else {
            return ResponseUtil.fail(505,"没有勾选");
        }
    }
}
