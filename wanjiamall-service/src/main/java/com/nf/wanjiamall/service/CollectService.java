package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.CollectEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author 南八
 */
public interface CollectService {
   Object getCollectList(Integer pageNum,Integer pageSize,CollectEntity collectEntity);
}
