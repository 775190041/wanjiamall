package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.Date;
import java.util.List;

public interface OrderDao {

    List<OrderEntity> getOrderList(@Param("pageNum") Integer pageNum,
                                   @Param("pageSize") Integer pageSize,
                                   @Param("orderStatus") List<Integer> orderStatus,
                                   @Param("userId") Integer userId,
                                   @Param("orderSn") String orderSn);

    OrderEntity getById(@Param("id") Integer id);

    int insertExpressMessage(@Param("id") Integer id,
                             @Param("shipChannel") String shipChannel,
                             @Param("shipSn") String shipSn,
                            @Param("shipTime") Date shipTime);

    //通过id改订单的状态值
    int updateOrderStatus(@Param("id") Integer id);

    /**
     *  wx 订单添加
     */
    int insertOrders(@Param("orderEntity") OrderEntity orderEntity);

    /**
     * wx 根据订单编号查询订单id
     */
    OrderEntity numberQueryOrderId(@Param("orderSn") String orderSn);

}
