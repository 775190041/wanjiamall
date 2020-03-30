package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.BrandDao;
import com.nf.wanjiamall.entity.BrandEntity;
import com.nf.wanjiamall.service.BrandService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
@Slf4j
public class BrandServiceImpl implements BrandService {
    @Autowired(required = false)
    private BrandDao brandDao;


    @Override
    public Object getByConditions(int pageNum, int pageSize, BrandEntity brandEntity) {
        List<BrandEntity> brandEntityList=brandDao.getByConditions(pageNum,pageSize,brandEntity);
        return ResponseUtil.okList(brandEntityList);
    }

    @Override
    public Object insert(BrandEntity brandEntity) {
        //添加之前查询是否有改品牌名称
        if (brandDao.checkExistByName(brandEntity.getName()) > 0 ){
            return ResponseUtil.existBrandFailure();
        }else {
            if (brandDao.insert(brandEntity)>0){
                return ResponseUtil.ok("添加成功");
            }else {
                return ResponseUtil.insertDataFailed();
            }
        }
    }

    @Override
    public Object updateById(BrandEntity brandEntity, Integer id) {
        //修改之前判断是否存在改品牌
        if (brandDao.checkExistByName(brandEntity.getName()) > 0 ){
            return ResponseUtil.existBrandFailure();
        }else {
            Integer count = brandDao.updateById(brandEntity,id);
            if (count >0 ){
                return ResponseUtil.ok("修改成功");
            }else {
                return ResponseUtil.updateDataFailed();
            }
        }
    }

    @Override
    public Object deleteById(Integer id) {
        //判断是否有商品绑定该品牌，如果有则无法删除
         if (brandDao.getProductByBrandCount(id) > 0){
             return ResponseUtil.deleteBrandFailure();
         }else {
             if (brandDao.deleteById(id) > 0){
                 return ResponseUtil.ok("删除成功");
             }else {
                 return ResponseUtil.deleteDataFailed();
             }
         }
    }
}
