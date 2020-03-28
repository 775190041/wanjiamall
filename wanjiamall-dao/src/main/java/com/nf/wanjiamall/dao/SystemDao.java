package com.nf.wanjiamall.dao;


import com.nf.wanjiamall.entity.SystemEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemDao {

    List<SystemEntity> selectValue();

    int updateAll(@Param("systemEntity") SystemEntity systemEntity);

    SystemEntity getFreight(@Param("keyName")String keyName);

}

