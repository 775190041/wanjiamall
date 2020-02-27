package com.nf.wanjiamall.service.impl;


import com.nf.wanjiamall.dao.CategoryDao;
import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lzn
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<CategoryEntity> getCateAll(Integer pageNum, Integer pageSize){
        List<CategoryEntity> categoryLists=categoryDao.getCateAll(pageNum,pageSize);
        for (CategoryEntity categoryList : categoryLists) {
            log.debug("---------"+categoryList);
        }
        return categoryLists;
    }

    @Override
    public void insertByLevelFirst(CategoryEntity categoryEntity) {
        categoryDao.insertByLevelFirst(categoryEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertByLevelSecond(CategoryEntity categoryEntity) {
        categoryDao.getFirstCate();
        categoryDao.insertByLevelFirst(categoryEntity);
    }

    @Override
    public void updateById(CategoryEntity categoryEntity, Integer id) {
        categoryDao.updateById(categoryEntity,id);
    }

}
