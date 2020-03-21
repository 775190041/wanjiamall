package com.nf.wanjiamall.service;

import java.util.List;

public interface AftersaleService {
    Object getAftersaleList(Integer pageNum,
                            Integer pageSize,
                            String aftersaleSn,
                            Integer orderId,
                            Integer status);

    Object batchAudit(List<Integer> ids,Integer status);


}
