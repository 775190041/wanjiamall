package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.GoodsAttributeDao;
import com.nf.wanjiamall.dao.GoodsDao;
import com.nf.wanjiamall.dao.GoodsProductDao;
import com.nf.wanjiamall.dao.GoodsSpecificationDao;
import com.nf.wanjiamall.entity.GoodsAttributeEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.entity.GoodsProductEntity;
import com.nf.wanjiamall.entity.GoodsSpecificationEntity;
import com.nf.wanjiamall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsSpecificationDao goodsSpecificationDao;
    @Autowired
    private GoodsProductDao goodsProductDao;
    @Autowired
    private GoodsAttributeDao goodsAttributeDao;

//    还有事务
    @Transactional
    @Override
    public boolean AddGoods(GoodsEntity goodsEntity, GoodsSpecificationEntity goodsSpecificationEntity, GoodsProductEntity goodsProductEntity, GoodsAttributeEntity goodsAttributeEntity) {
       if(goodsDao.insert(goodsEntity)>0 && goodsSpecificationDao.insert(goodsSpecificationEntity)>0
       && goodsProductDao.insert(goodsProductEntity)>0 &&  goodsAttributeDao.insert(goodsAttributeEntity)>0){
           return true;
       }else {
           return false;
       }
    }
}
