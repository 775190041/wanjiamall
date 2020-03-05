package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.CouponDao;
import com.nf.wanjiamall.dao.CouponUserDao;
import com.nf.wanjiamall.entity.CouponEntity;
import com.nf.wanjiamall.entity.CouponUserEntity;
import com.nf.wanjiamall.service.CouponUserService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.CouponVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CouponUserServiceImpl implements CouponUserService {
    @Autowired
    private CouponDao couponDao;
    @Autowired
    private CouponUserDao couponUserDao;

    @Override
    public Object getCouponUserAll(Integer pageNum, Integer pageSize, CouponUserEntity couponUserEntity) {
        List<CouponEntity> list = couponDao.getAll();
        List<CouponUserEntity> couponUser= null;
        for (CouponEntity couponEntity : list) {
            couponUser = couponUserDao.getCouponUserByAll(pageNum, pageSize, couponUserEntity,couponEntity.getId());
        }
        return ResponseUtil.ok(couponUser);
    }
}
