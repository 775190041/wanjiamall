package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.CouponDao;
import com.nf.wanjiamall.dao.CouponUserDao;
import com.nf.wanjiamall.entity.CouponEntity;
import com.nf.wanjiamall.entity.CouponUserEntity;
import com.nf.wanjiamall.service.wx.WxCouponService;
import com.nf.wanjiamall.utils.AftersaleConstant;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author lrc
 */
@Slf4j
@Service
public class WxCouponServiceImpl implements WxCouponService {

    @Autowired(required = false)
    private CouponDao couponDao;
    @Autowired(required = false)
    private CouponUserDao couponUserDao;

    @Override
    public Object getCouponAll(Integer pageNum, Integer pageSize, CouponEntity couponEntity) {
        return  ResponseUtil.okList(couponDao.getCouponAll(pageNum, pageSize, couponEntity));
    }

    @Override
    public Object getCouponById(Integer userId,Integer couponId) {
        Integer coupon_id = couponUserDao.getCouponUserGetByCouponId(userId,couponId);
        if (coupon_id !=null){
            return ResponseUtil.fail(400,"该优惠券已被领取");
        }else{
            if (couponUserDao.insertCouponUser(userId,couponId)>0){
                return ResponseUtil.ok(false);
            }else {
                return ResponseUtil.fail(505,"领取失败！");
            }
        }
    }

    /**
     * 检测优惠券是否适合
     */
    @Override
    public CouponEntity checkCoupon(Integer userId, Integer couponId, Integer userCouponId, BigDecimal checkedGoodsPrice) {
        //查看优惠券是否存在
        CouponEntity coupon = couponDao.getCouponById(couponId);
        if (coupon == null) {
            return null;
        }
        //查看用户优惠卷是否存在
        CouponUserEntity couponUser = couponUserDao.getUserCouponIdOrUesrId(userCouponId,userId);
        if (couponUser == null) {
            return null;
        }
        //判断优惠券与用户优惠是否相同
        if (!couponId.equals(couponUser.getCouponId())) {
            return null;
        }
        // 检查是否超期
        Integer timeType = coupon.getTimeType();
        Integer days = coupon.getDays();
        LocalDateTime date = LocalDateTime.now();
        if (timeType.equals(AftersaleConstant.TYPE_GOODS_NEEDLESS)) {
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zdt = date.atZone(zoneId);
            Date dates = Date.from(zdt.toInstant());
            if (dates.before(coupon.getStartTime()) && dates.after((coupon.getAddTime()))) {
                return coupon;
            }
        }
        //有效时限制是0
        else if(timeType.equals(AftersaleConstant.TYPE_GOODS_MISS)) {
            //把基于时间的有效天数加到时间中
            LocalDateTime now = couponUser.getAddTime().toLocalDateTime().plusDays(days);
            if (date.isBefore(now)) {
                return coupon;
            }
        }
        else {
            return null;
        }
        // 检测商品是否符合
        Integer goodType = coupon.getGoodsType();
        if (!goodType.equals(AftersaleConstant.TYPE_GOODS_MISS)){
            return null;
        }
        // 检测订单状态
        Integer status = coupon.getStatus();
        if (!status.equals(AftersaleConstant.TYPE_GOODS_MISS)) {
            return null;
        }
        // 检测是否满足最低消费
        if (checkedGoodsPrice.compareTo(coupon.getMin()) == -1) {
            return null;
        }
        return coupon;
    }
}
