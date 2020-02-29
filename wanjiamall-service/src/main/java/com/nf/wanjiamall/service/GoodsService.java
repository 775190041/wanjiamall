package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.GoodsAttributeEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.entity.GoodsProductEntity;
import com.nf.wanjiamall.entity.GoodsSpecificationEntity;

public interface GoodsService {

/**
 * 商品上架
 */
    boolean AddGoods(GoodsEntity goodsEntity, GoodsSpecificationEntity goodsSpecificationEntity
                    , GoodsProductEntity goodsProductEntity,GoodsAttributeEntity goodsAttributeEntity);

}
