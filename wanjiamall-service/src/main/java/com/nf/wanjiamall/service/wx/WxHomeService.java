package com.nf.wanjiamall.service.wx;

/**
 * @author lzn
 */
public interface WxHomeService {
    Object getHomeData();

    Object getCateData(Integer pageNum,Integer pageSize,Integer cateId);

    Object getGoodsData(Integer pageNum,Integer pageSize,Integer cateId);
}
