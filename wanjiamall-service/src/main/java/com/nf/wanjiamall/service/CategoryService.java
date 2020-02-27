package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface CategoryService {
    List<CategoryEntity> getCateAll(Integer pageNum, Integer pageSize);

    void insertByLevelFirst(CategoryEntity categoryEntity);

    void updateById(CategoryEntity categoryEntity,Integer id);
}
