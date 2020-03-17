package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.ResourceEntity;

import java.util.List;

/**
 * @author 黑夜
 */
public interface ResourceService {

    Object
    listResource(Integer pageNum,Integer pageSize,Integer categoryId,String name,String url);

    Object updateResource(Integer id,ResourceEntity resourceEntity);

    Object insertResource(ResourceEntity resourceEntity);

    Object getByIdResource(Integer id);

    Object deleteResource(Integer id);

    List<ResourceEntity> getResourceByAdminIdList(Integer adminId);
}
