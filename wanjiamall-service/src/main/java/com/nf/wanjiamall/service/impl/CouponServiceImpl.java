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
    public Object getAll(Integer pageNum, Integer pageSize,CouponEntity couponEntity) {
        List<CouponEntity> list = couponDao.getAll(pageNum,pageSize,couponEntity);
        return ResponseUtil.okList(list);
    }


    @Override
    public Object insertCoupon(CouponEntity couponEntity) {
//        if (couponEntity.getTimeType())
        Integer count = couponDao.insertCoupon(couponEntity);
        if (count >0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"添加失败！");
        }

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
