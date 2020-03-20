package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

    List<OrderEntity> getOrderList(@Param("pageNum") Integer pageNum,
                                   @Param("pageSize") Integer pageSize,
                                   @Param("orderStatus") List<Integer> orderStatus,
                                   @Param("userId") Integer userId,
                                   @Param("orderSn") String orderSn);

    OrderEntity getById(@Param("id") Integer id);
}
