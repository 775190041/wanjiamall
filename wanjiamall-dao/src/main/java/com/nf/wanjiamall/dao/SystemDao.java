package com.nf.wanjiamall.dao;


import com.nf.wanjiamall.entity.SystemEntity;
import org.apache.ibatis.annotations.Param;

public interface SystemDao {

    SystemEntity selectValue();

    int updateAll(@Param("systemEntity") SystemEntity systemEntity);

}

