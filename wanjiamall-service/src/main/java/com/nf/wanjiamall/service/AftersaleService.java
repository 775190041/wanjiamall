package com.nf.wanjiamall.service;

public interface AftersaleService {
    Object getAftersaleList(Integer pageNum,
                            Integer pageSize,
                            String aftersaleSn,
                            Integer orderId,
                            Integer status);
}
