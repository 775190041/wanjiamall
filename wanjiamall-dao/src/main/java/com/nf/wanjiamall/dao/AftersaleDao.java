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


}
