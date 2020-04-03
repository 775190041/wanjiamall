package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.CouponDao;
import com.nf.wanjiamall.dao.CouponUserDao;
import com.nf.wanjiamall.entity.CouponEntity;
import com.nf.wanjiamall.entity.CouponUserEntity;
import com.nf.wanjiamall.service.CouponService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.CouponVO;
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
    @Autowired
    private CouponUserDao couponUserDao;

    @Override
    public Object getCouponAll(Integer pageNum, Integer pageSize, CouponEntity couponEntity) {
        List<CouponEntity> list = couponDao.getCouponAll(pageNum,pageSize,couponEntity);
        return ResponseUtil.okList(list);
    }

    @Override
    public Object getCouponById(Integer pageNum, Integer pageSize, Integer id,CouponUserEntity couponUserEntity) {
        CouponEntity couponEntity = couponDao.getCouponById(id);
        List<CouponUserEntity> couponUserEntities =
                couponUserDao.getCouponUserByAll(pageNum,pageSize,couponUserEntity,id);
        CouponVO vo = new CouponVO();
        vo.setCoupon(couponEntity);
        vo.setCouponUser(ResponseUtil.okList(couponUserEntities));
        return vo;
    }



    @Override
    public Object insertCoupon(CouponEntity couponEntity) {
        if (couponEntity.getTimeType() == 0 && couponEntity.getType() !=2 ){
            Integer count = couponDao.insertCouponDay(couponEntity);
            if (count >0){
                return ResponseUtil.ok();
            }else {
                return ResponseUtil.fail(505,"添加失败！");
            }
        }else if (couponEntity.getTimeType() == 1 && couponEntity.getType() !=2){
            Integer count = couponDao.insertCouponTime(couponEntity);
            if (count >0){
                return ResponseUtil.ok();
            }else {
                return ResponseUtil.fail(505,"添加失败！");
            }
        }else if (couponEntity.getTimeType() == 0 && couponEntity.getType() ==2){
            String code = createBigStrOrNumberRadom(6);
            couponEntity.setCode(code);
            Integer count = couponDao.insertCouponCodeDay(couponEntity);
            if (count >0){
                return ResponseUtil.ok();
            }else {
                return ResponseUtil.fail(505,"添加失败！");
            }
        }else if (couponEntity.getTimeType() == 1 && couponEntity.getType() ==2){
            String code = createBigStrOrNumberRadom(6);
            couponEntity.setCode(code);
            Integer count = couponDao.insertCouponCodeTime(couponEntity);
            if (count >0){
                return ResponseUtil.ok();
            }else {
                return ResponseUtil.fail(505,"添加失败！");
            }
        }
        return ResponseUtil.fail();

    }

    /**
     *
     * @function 生成num位的随机字符串(大写字母与数字混排)
     * @param num
     * @return
     */
    public static String createBigStrOrNumberRadom(int num) {
        String str = "";
        for(int i=0;i < num;i++){
            int intVal=(int)(Math.random()*26+65);
            if(intVal%2==0){
                str += (char)intVal;
            }else{
                str += (int)(Math.random()*10);
            }
        }
        return str;
    }

    @Override
    public Object updateCoupon(CouponEntity couponEntity, Integer id) {
        if (couponEntity.getTimeType() == 0 && couponEntity.getType() !=2 ){
            String code ="";
            couponEntity.setCode(code);
            Integer count = couponDao.updateCouponCodeDay(couponEntity,id);
            if (count >0){
                return ResponseUtil.ok();
            }else {
                return ResponseUtil.fail(505,"修改失败！");
            }
        }else if (couponEntity.getTimeType() == 1 && couponEntity.getType() !=2){
            String code ="";
            couponEntity.setCode(code);
            Integer count = couponDao.updateCouponCodeTime(couponEntity,id);
            if (count >0){
                return ResponseUtil.ok();
            }else {
                return ResponseUtil.fail(505,"修改失败！");
            }
        }else if (couponEntity.getTimeType() == 0 && couponEntity.getType() ==2){
            String code = createBigStrOrNumberRadom(6);
            couponEntity.setCode(code);
            Integer count = couponDao.updateCouponCodeDay(couponEntity,id);
            if (count >0){
                return ResponseUtil.ok();
            }else {
                return ResponseUtil.fail(505,"修改失败！");
            }
        }else if (couponEntity.getTimeType() == 1 && couponEntity.getType() ==2){
            String code = createBigStrOrNumberRadom(6);
            couponEntity.setCode(code);
            Integer count = couponDao.updateCouponCodeTime(couponEntity,id);
            if (count >0){
                return ResponseUtil.ok();
            }else {
                return ResponseUtil.fail(505,"修改失败！");
            }
        }
        return ResponseUtil.fail();
    }

    @Override
    public Object deletedCouponId(Integer id) {
        couponDao.deletedCouponId(id);
        return ResponseUtil.ok();
    }

    @Override
    public Object getCouponIdQuery(Integer couponId) {
        return couponDao.getCouponById(couponId);
    }
}
