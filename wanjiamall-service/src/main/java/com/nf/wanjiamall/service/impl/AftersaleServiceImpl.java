package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.AftersaleDao;
import com.nf.wanjiamall.dao.OrderDao;
import com.nf.wanjiamall.dao.OrderGoodsDao;
import com.nf.wanjiamall.dao.UserDao;
import com.nf.wanjiamall.entity.AftersaleEntity;
import com.nf.wanjiamall.entity.OrderEntity;
import com.nf.wanjiamall.entity.OrderGoodsEntity;
import com.nf.wanjiamall.entity.UserEntity;
import com.nf.wanjiamall.service.AftersaleService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class AftersaleServiceImpl implements AftersaleService {
    @Autowired(required = false)
    private AftersaleDao aftersaleDao;
    @Autowired(required = false)
    private OrderDao orderDao;
    @Autowired(required = false)
    private OrderGoodsDao orderGoodsDao;

    @Autowired(required = false)
    private UserDao userDao;

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
                AftersaleEntity aftersaleEntity = aftersaleDao.getById(id);
                //跳过通过与拒绝
                if (aftersaleEntity.getStatus() == 3||aftersaleEntity.getStatus()==5) {
                    continue;
                } else {
                    aftersaleDao.batchAudit(id, status);
                }
            }
            return ResponseUtil.ok("批量修改成功");
        }else {
            return ResponseUtil.fail(505,"没有勾选");
        }
    }

    //查售后详情
    @Override
    public Object getAftersaleDetail(Integer id) {
        //查询订单信息
        OrderEntity orderEntity = orderDao.getById(id);
        //查询该订单商品信息
        List<OrderGoodsEntity> orderGoodsEntities = orderGoodsDao.getByOrderId(id);
        //查询该该订单用户信息
        UserEntity userEntity = userDao.getById(orderEntity.getUserId());
        AftersaleEntity aftersaleEntity = aftersaleDao.getByOrderId(id);
        Map<String,Object> date = new HashMap<>();
        date.put("order",orderEntity);
        date.put("orderGoods",orderGoodsEntities);
        date.put("user",userEntity);
        date.put("aftersaleEntity",aftersaleEntity);
        return ResponseUtil.ok(date);
    }
}
