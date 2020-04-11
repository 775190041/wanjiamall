package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.OrderGoodsEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface OrderGoodsDao {

    List<OrderGoodsEntity> getByOrderId(@Param("orderId") Integer orderId);

    /**
     * 订单商品添加
     */
    int insertOrderGoods(@Param("orderGoodsEntity") OrderGoodsEntity orderGoodsEntity);
}
