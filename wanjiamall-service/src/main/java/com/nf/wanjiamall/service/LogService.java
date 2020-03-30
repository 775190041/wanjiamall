package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.LogEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogService {

    Object logInsert(LogEntity logEntity);

    Object getLogList(Integer pageNum,Integer pageSize, String name);


    Object logDelete(Integer id);
}
