package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.ResourceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 黑夜
 * 资源路径
 */
public interface ResourceDao {
    List<ResourceEntity> listResource(@Param("pageNum") Integer pageNum,
                                      @Param("pageSize") Integer pageSize,
                                      @Param("categoryId") Integer categoryId,
                                      @Param("name") String name,
                                      @Param("url") String url);


    int updateResource(@Param("id")Integer id,@Param("resourceEntity") ResourceEntity resourceEntity);

    int insertResource (@Param("resourceEntity") ResourceEntity resourceEntity);

    ResourceEntity getByIdResource(@Param("id") Integer id);

    int deleteResource(@Param("id") Integer id);

}
