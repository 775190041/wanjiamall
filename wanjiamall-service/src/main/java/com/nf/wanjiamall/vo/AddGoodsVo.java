package com.nf.wanjiamall.vo;

import com.nf.wanjiamall.entity.GoodsAttributeEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.entity.GoodsProductEntity;
import com.nf.wanjiamall.entity.GoodsSpecificationEntity;
import lombok.Data;

@Data
public class AddGoodsVo {
    GoodsEntity goodsEntity;
    GoodsSpecificationEntity[] goodsSpecificationEntity;
    GoodsProductEntity[] goodsProductEntities;
    GoodsAttributeEntity[] goodsAttributeEntity;
}
