package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.SystemEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface SystemService {


    /**
     * 查询所有配置信息
     */
    Object selectValue();


    /**
     * 运费配置  订单配置 小程序配置
     */
    Object updateFreight(String  system);


}
