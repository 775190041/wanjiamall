package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.LogEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogDao {

    int logInsert(LogEntity logEntity);

    List<LogEntity> getLogList(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize,@Param("name") String name);


    int logDelete(Integer id);
}
