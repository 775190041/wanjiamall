package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.SystemEntity;
import org.apache.ibatis.annotations.Param;

public interface SystemService {

    /**
     * 运费配置
     */
    Object selectByFreightValue();
    Object updateFreight( int id, SystemEntity systemEntity);

    /**
     * 订单配置
     */
    Object selectByOrderValue();
    Object updateOrder( int id, SystemEntity systemEntity);

    /**
     * 小程序配置
     */
    Object selectByAppletValue();
    Object updateApplet(int id, SystemEntity systemEntity);
}
