package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.CouponDao;
import com.nf.wanjiamall.dao.CouponUserDao;
import com.nf.wanjiamall.entity.CouponEntity;
import com.nf.wanjiamall.entity.CouponUserEntity;
import com.nf.wanjiamall.service.wx.WxCouponService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lrc
 */
@Slf4j
@Service
public class WxCouponServiceImpl implements WxCouponService {

    @Autowired
    private CouponDao couponDao;
    @Autowired
    private CouponUserDao couponUserDao;

    @Override
    public Object getCouponAll(Integer pageNum, Integer pageSize, CouponEntity couponEntity) {
        return  ResponseUtil.okList(couponDao.getCouponAll(pageNum, pageSize, couponEntity));
    }

    @Override
    public Object getCouponById(Integer pageNum, Integer pageSize, String username, Integer id) {
        List<CouponUserEntity> list = couponUserDao.getCouponUserGet(pageNum, pageSize, username);
        if (list !=null){
            for (CouponUserEntity couponUserEntity : list) {
                if (id.equals(couponUserEntity.getCouponId())){
                    return ResponseUtil.ok(true);
                }else {
                    if (couponUserDao.insertCouponUser(username,id)>0){
                        return ResponseUtil.ok(false);
                    }else {
                        return ResponseUtil.fail(505,"领取失败！");
                    }
                }
            }
        }
        if (couponUserDao.insertCouponUser(username,id)>0){
            return ResponseUtil.ok(false);
        }else {
            return ResponseUtil.fail(505,"领取失败！");
        }

    }
}
