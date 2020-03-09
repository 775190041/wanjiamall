package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.CategoryDao;
import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.service.CategoryService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.CategoryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzn
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public List<CategoryVo> getAll(Integer pageNum,Integer pageSize){
        List<CategoryVo> categoryVoList = new ArrayList<>();
        List<CategoryEntity> cateFirstLists = categoryDao.getFirstCate(pageNum, pageSize);
        for (CategoryEntity category : cateFirstLists) {
            System.out.println("category = " + category);
            CategoryVo categoryVO = new CategoryVo();
            categoryVO.setId(category.getId());
            categoryVO.setCategoryDesc(category.getCategoryDesc());
            categoryVO.setIconUrl(category.getIconUrl());
            categoryVO.setPicUrl(category.getPicUrl());
            categoryVO.setName(category.getName());
            categoryVO.setLevel(category.getLevel());
            List<CategoryVo> children = new ArrayList<>();
            List<CategoryEntity> subCategoryList = categoryDao.getSecondCate(category.getId());
            for (CategoryEntity categoryEntity : subCategoryList) {
                CategoryVo subCategoryVo = new CategoryVo();
                subCategoryVo.setId(categoryEntity.getId());
                subCategoryVo.setCategoryDesc(categoryEntity.getCategoryDesc());
                subCategoryVo.setIconUrl(categoryEntity.getIconUrl());
                subCategoryVo.setPicUrl(categoryEntity.getPicUrl());
                subCategoryVo.setName(categoryEntity.getName());
                subCategoryVo.setLevel(categoryEntity.getLevel());
                children.add(subCategoryVo);
            }
            categoryVO.setChildren(children);
            categoryVoList.add(categoryVO);
        }
        return categoryVoList;
    }

    /**
     * 查询所有的目录
     * @return
     */
    @Override
    public Object getAllCategory(Integer pageNum,Integer pageSize) {
        return ResponseUtil.ok(getAll(pageNum, pageSize));
    }


    /**
     * 根据需求查询目录
     * @return
     */
    @Override
    public Object getDemandCategory(Integer pageNum,Integer pageSize) {
       return ResponseUtil.ok(categoryDao.getFirstCate(pageNum,pageSize));
    }


    @Override
    public List<CategoryEntity> getFirstCate(Integer pageNum,Integer pageSize) {
        return categoryDao.getFirstCate(pageNum, pageSize);
    }

    @Override
    public List<CategoryEntity> getSecondCate(Integer pid) {
        return categoryDao.getSecondCate(pid);
    }


    @Override
    public Object insertByLevel(CategoryEntity categoryEntity) {
        if (  categoryDao.insertByLevel(categoryEntity) >0){
           return ResponseUtil.ok();
        }else {
           return ResponseUtil.fail(505,"添加失败");
        }

    }
    @Override
    public Object updateById(CategoryEntity categoryEntity, Integer id) {
        if (categoryDao.updateById(categoryEntity,id) >0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"修改失败");
        }

    }



    @Override
    public Object deleteById(Integer id) {
        //先判断选中的id值为一级类目还是二级类目
        Integer level=categoryDao.getIdByLevel(id);
        if (level==1){
            //删除父类目前先判断其是否有二级类目,如果secondCateNum=0,说明没有二级类目，顺利删除；否则，不能删除。
            Integer secondCateNum=categoryDao.getSecondCateCount(id);
            if (secondCateNum==0){
                categoryDao.deleteById(id);
               return ResponseUtil.ok();
            }else {
               return ResponseUtil.fail(505,"有子目录，不能删除");
            }
        }else {
            Integer secondCateProductNum=categoryDao.getProductBySecondCateCount(id);
            if (secondCateProductNum==0){
                categoryDao.deleteById(id);
                return  ResponseUtil.ok();
            }else {
                return ResponseUtil.fail(505,"有商品绑定，无法删除");
            }
        }
    }


}
