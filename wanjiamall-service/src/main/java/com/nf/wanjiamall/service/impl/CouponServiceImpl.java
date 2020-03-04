package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.CouponDao;
import com.nf.wanjiamall.entity.CouponEntity;
import com.nf.wanjiamall.service.CouponService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lrc
 */

@Service
@Slf4j
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponDao couponDao;

    @Override
    public Object getAll(Integer pageNum, Integer pageSize) {
        List<CouponEntity> list = couponDao.getAll(pageNum,pageSize);
        return ResponseUtil.okList(list);
    }

    @Override
    public Object getByCoupon(Integer pageNum, Integer pageSize, String name, Integer type, Integer status) {
        List<CouponEntity> list = couponDao.getByCoupon(pageNum,pageSize,name,type,status);
        return ResponseUtil.okList(list);
    }

    @Override
    public Object insertCoupon(CouponEntity couponEntity) {
        couponDao.insertCoupon(couponEntity);
        return ResponseUtil.ok();
    }

    @Override
    public Object updateCoupon(CouponEntity couponEntity, Integer id) {
        couponDao.updateCoupon(couponEntity,id);
        return ResponseUtil.ok();
    }

    @Override
    public Object deletedCouponId(Integer id) {
        couponDao.deletedCouponId(id);
        return ResponseUtil.ok();
    }
}
