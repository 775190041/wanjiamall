package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.OrderDao;
import com.nf.wanjiamall.dao.OrderGoodsDao;
import com.nf.wanjiamall.dao.UserDao;
import com.nf.wanjiamall.entity.OrderEntity;
import com.nf.wanjiamall.entity.OrderGoodsEntity;
import com.nf.wanjiamall.entity.UserEntity;
import com.nf.wanjiamall.service.OrderService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired(required = false)
    private OrderDao orderDao;

    @Autowired(required = false)
    private OrderGoodsDao orderGoodsDao;

    @Autowired(required = false)
    private UserDao userDao;


    @Override
    public Object getOrderList(Integer pageNum,
                               Integer pageSize,
                               List<Integer> orderStatus,
                               Integer userId,
                               String orderSn) {
        return ResponseUtil.okList(orderDao.getOrderList(pageNum,pageSize,orderStatus,userId,orderSn));
    }

    /**
     * 通过订单号查询商品详情，
     * 查用户昵称
     * 商品信息
     * 订单信息
     * @param id
     * @return
     */
    @Override
    public Object getOrderDetail(Integer id) {
        //查询订单信息
        OrderEntity orderEntity = orderDao.getById(id);
        //查询该订单商品信息
        List<OrderGoodsEntity> orderGoodsEntities = orderGoodsDao.getByOrderId(id);
        //查询该该订单用户信息
        UserEntity userEntity = userDao.getById(orderEntity.getUserId());
        Map<String,Object> date = new HashMap<>();
        date.put("orderEntity",orderEntity);
        date.put("orderGoodsEntities",orderGoodsEntities);
        date.put("userEntity",userEntity);
        return ResponseUtil.ok(date);
    }

    @Override
    public Object insertExpressMessage(Integer id, String shipChannel, String shipSn) {
        Integer count = orderDao.insertExpressMessage(id,shipChannel,shipSn);
        if (count > 0 ){
            orderDao.updateOrderStatus(id);
            return ResponseUtil.ok("发货成功");
        }else {
            return ResponseUtil.fail(505,"发货失败");
        }

    }

}

