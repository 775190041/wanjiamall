package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.CollectEntity;

/**
 * @author 南八
 */
public interface CollectService {
   Object getCollectList(Integer pageNum,Integer pageSize,CollectEntity collectEntity);
   Object getCollectByUserId(Integer pageNum,Integer pageSize,Integer userId);
   Object getCollectInsertAndDelete(Integer userId,Integer goodsId);
   Object collectInsert(Integer userId,Integer goodsId);
   Object collectDelete( Integer userId,Integer goodsId);
}
