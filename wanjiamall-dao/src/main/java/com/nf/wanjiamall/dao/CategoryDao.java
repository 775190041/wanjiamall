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
    List<CategoryEntity> getFirstCate(@Param("pageNum") Integer pageNum,
                                      @Param("pageSize") Integer pageSize);

    CategoryEntity cateEntity(Integer id);

    /**
     * 获取选中的父类目的二级类目信息
     */
    List<CategoryEntity> getSecondCate(Integer pid);

    /**
     * 添加类目
     */
    int insertByLevel(CategoryEntity categoryEntity);

    List<CategoryEntity> getById(Integer id);

    /**
     * 通过id，查询全部信息
     * @param id
     * @return
     */
    CategoryEntity getByIdDetail(Integer id);



    int updateById(@Param("cate") CategoryEntity categoryEntity,Integer id);

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

    /**
     * 获取和关键字相关的类目
     */
    List<CategoryEntity> getKeyCate(@Param("pageNum") Integer pageNum,
                                    @Param("pageSize") Integer pageSize,
                                    @Param("keywords") String keywords);

    /**
     * 获取和新品推荐相关的类目
     */
    List<CategoryEntity> getNewsCate(@Param("pageNum") Integer pageNum,
                                    @Param("pageSize") Integer pageSize);

    /**
     * 获取和人气推荐相关的类目
     */
    List<CategoryEntity> getHotCate(@Param("pageNum") Integer pageNum,
                                     @Param("pageSize") Integer pageSize);

}
