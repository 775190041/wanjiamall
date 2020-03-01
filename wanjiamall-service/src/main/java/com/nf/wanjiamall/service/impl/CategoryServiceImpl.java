package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.CategoryDao;
import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.exception.AppException;
import com.nf.wanjiamall.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<CategoryEntity> getFirstCate() {
        return categoryDao.getFirstCate();
    }

    @Override
    public List<CategoryEntity> getSecondCate(Integer pid) {
        return categoryDao.getSecondCate(pid);
    }


    @Override
    public void insertByLevel(CategoryEntity categoryEntity) {
            categoryDao.insertByLevelFirst(categoryEntity);
    }

    @Override
    public void updateById(CategoryEntity categoryEntity, Integer id) {
        categoryDao.getById(id);
        categoryDao.updateById(categoryEntity,id);
    }



    @Override
    public void deleteById(Integer id) {
        Integer level=categoryDao.getIdByLevel(id);
        if (level==1){
            Integer secondCateNum=categoryDao.getSecondCateCount(id);
            if (secondCateNum==0){
                categoryDao.deleteById(id);
            }else{
                throw  new AppException("无法删除");
            }
        }else {
            Integer secondCateProductNum=categoryDao.getProductBySecondCateCount(id);
            if (secondCateProductNum==0){
                categoryDao.deleteById(id);
            }
        }
    }


}
