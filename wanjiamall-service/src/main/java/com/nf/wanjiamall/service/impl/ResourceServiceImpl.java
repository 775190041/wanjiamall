package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.ResourceDao;
import com.nf.wanjiamall.entity.ResourceEntity;
import com.nf.wanjiamall.service.ResourceService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 黑夜
 */
@Service
@Slf4j
public class ResourceServiceImpl implements ResourceService {
    @Autowired(required = false)
    private ResourceDao resourceDao;

    /**
     *
     * 查询
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @param name
     * @param url
     * @return
     */
    @Override
    public Object listResource(Integer pageNum, Integer pageSize, Integer categoryId, String name, String url) {
        return ResponseUtil.okList(resourceDao.listResource(pageNum,pageSize,categoryId,name,url));
    }

    @Override
    public Object updateResource(ResourceEntity resourceEntity) {
        Integer count =  resourceDao.updateResource(resourceEntity);
       if (count>0){
           return ResponseUtil.ok("修改成功");
       }else {
           return ResponseUtil.fail(505,"修改失败");
       }
    }


    @Override
    public Object insertResource(ResourceEntity resourceEntity) {
        Integer count = resourceDao.insertResource(resourceEntity);
        if (count>0){
            return ResponseUtil.ok("添加成功");
        }else {
            return ResponseUtil.fail(505,"添加失败");
        }

    }

    @Override
    public Object getByIdResource(Integer id) {
        return ResponseUtil.ok(resourceDao.getByIdResource(id));
    }

    @Override
    public Object deleteResource(Integer id) {
        Integer count = resourceDao.deleteResource(id);
        if (count> 0 ){
            return ResponseUtil.ok("删除成功");
        }else {
            return ResponseUtil.fail(505,"删除失败");
        }
    }
}
