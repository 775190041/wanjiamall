package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface CategoryService {
    /**
     * 查询目录所有信息
     */
    Object getAllCategory(Integer pageNum,Integer pageSize);


    /**
     * 根据需求查询目录
     * @return
     */

    Object getDemandCategory(Integer pageNum,Integer pageSize);

    //删除
    List<CategoryEntity> getFirstCate(Integer pageNum,Integer pageSize);
    //删除
    List<CategoryEntity> getSecondCate(Integer pid);



    Object insertByLevel(CategoryEntity categoryEntity);

    Object updateById(CategoryEntity categoryEntity,Integer id);

    Object deleteById(Integer id);
}
