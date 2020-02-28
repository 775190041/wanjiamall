package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface CategoryDao {
    /**
     * 获取父类目的信息
     */
    List<CategoryEntity> getFirstCate();

    /**
     * 获取选中的父类目的二级类目信息
     */
    List<CategoryEntity> getSecondCate(Integer pid);

    /**
     * 根据类目级别进行添加
     */
    void insertByLevelFirst(CategoryEntity categoryEntity);

    List<CategoryEntity> getById(Integer id);
    void updateById(@Param("cate") CategoryEntity categoryEntity,Integer id);

    /**
     * 先判断选中的id值为一级类目还是二级类目
     */
    Integer getIdByLevel(Integer id);

    /**
     * 删除父类目前先判断其是否有二级类目,如果count=0,说明没有二级类目，顺利删除；否则，不能删除。
     */
    Integer getSecondCateCount(Integer id);

    /**
     * 删除二级类目前先判断其是否有商品绑定，如果count=0,说明没有二级类目，顺利删除；否则，不能删除。
     */
    Integer getProductBySecondCateCount(Integer id);

    void deleteById(Integer id);
}
