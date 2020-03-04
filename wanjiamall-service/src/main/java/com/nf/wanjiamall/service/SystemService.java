package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.SystemEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface SystemService {

    /**
     * 运费配置
     */
    Object selectByFreightValue();
    Object updateFreight(String  systemFreight);

    /**
     * 订单配置
     */
    Object selectByOrderValue();
    Object updateOrder(SystemEntity systemOrder);

    /**
     * 小程序配置
     */
    Object selectByAppletValue();
    Object updateApplet( SystemEntity systemApplet);
}
