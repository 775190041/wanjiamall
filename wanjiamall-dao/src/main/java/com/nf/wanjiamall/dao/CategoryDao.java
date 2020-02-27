package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface CategoryDao {
    List<CategoryEntity> getCateAll(@Param("pageNum") int pageNum,
                                    @Param("pageSize") int pageSize);

    void insertByLevelFirst(CategoryEntity categoryEntity);

    //获取一级目录
    List<CategoryEntity> getFirstCate();

    //获取选中的父目录的二级目录信息
    List<CategoryEntity> getSecondCate(Integer pid);

    void updateById(CategoryEntity categoryEntity,@Param("id") Integer id);
}
