package com.nf.wanjiamall.service;

import java.util.List;

public interface OrderService {
    Object getOrderList(Integer pageNum,
                        Integer pageSize,
                        List<Integer> orderStatus,
                        Integer userId,
                        String orderSn);

    Object getOrderDetail(Integer id);
}
