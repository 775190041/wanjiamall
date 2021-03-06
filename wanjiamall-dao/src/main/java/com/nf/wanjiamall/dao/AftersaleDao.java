package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.AftersaleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AftersaleDao {

    List<AftersaleEntity> getAftersaleList(@Param("pageNum") Integer pageNum,
                                           @Param("pageSize") Integer pageSize,
                                          @Param("aftersaleSn") String aftersaleSn,
                                          @Param("orderId") Integer orderId,
                                          @Param("status") Integer status);


    int batchAudit(@Param("id") Integer id,@Param("status") Integer status);

    AftersaleEntity getById(@Param("id") Integer id);

    AftersaleEntity getByOrderId(@Param("orderId") Integer orderId);

}
