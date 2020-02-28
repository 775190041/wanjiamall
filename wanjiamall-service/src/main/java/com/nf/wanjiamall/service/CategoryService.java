package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface CategoryService {
    List<CategoryEntity> getFirstCate();

    List<CategoryEntity> getSecondCate(Integer pid);

    void insertByLevel(CategoryEntity categoryEntity);

    void updateById(CategoryEntity categoryEntity,Integer id);

    void deleteById(Integer id);
}
