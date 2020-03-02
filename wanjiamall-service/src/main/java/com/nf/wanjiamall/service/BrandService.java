package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.BrandEntity;

import java.util.List;

/**
 * @author lzn
 */
public interface BrandService {
    Object getByConditions(int pageNum, int pageSize, BrandEntity brandEntity);

    Object insert(BrandEntity brandEntity);

    Object updateById(BrandEntity entity,Integer id);

    Object deleteById(Integer id);
}
