package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.OrderGoodsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGoodsDao {
    List<OrderGoodsEntity> getByOrderId(@Param("orderId") Integer orderId);



}
