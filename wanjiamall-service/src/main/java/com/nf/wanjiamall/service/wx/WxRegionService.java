package com.nf.wanjiamall.service.wx;

/**
 * 行政区域表 服务类
 */
public interface WxRegionService {
    /**
     * 查询行政区域省级
     * @return
     */
    Object getRegionProvinceQuery();

    /**
     * 查询行政区域 市 县 区级
     */
    Object getRegionPidCityQuery(Integer type , Integer pId);

}
