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
    @Autowired
    private BrandDao brandDao;

    @Override
    public Object getByConditions(int pageNum, int pageSize, BrandEntity brandEntity) {
        List<BrandEntity> brandEntityList=brandDao.getByConditions(pageNum,pageSize,brandEntity);
        return ResponseUtil.okList(brandEntityList);
    }

    @Override
    public Object insert(BrandEntity brandEntity) {
        List<BrandEntity> getBrandNames=brandDao.getAll();
        if (brandDao.insert(brandEntity)>0){
            for (BrandEntity getBrandName : getBrandNames) {
                if (brandEntity.getName().equals(getBrandName.getName())){
                    return ResponseUtil.fail(505,"已存在该品牌名，添加失败！");
                }
            }
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"添加失败！");
        }
    }

    @Override
    public Object updateById(BrandEntity brandEntity, Integer id) {
        if (brandDao.updateById(brandEntity,id) >0){
            brandDao.updateById(brandEntity,id);
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"修改失败");
        }
    }

    @Override
    public Object deleteById(Integer id) {
        Integer num=brandDao.getProductByBrandCount(id);
        if (num==0){
            brandDao.deleteById(id);
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"有商品绑定，无法删除");
        }
    }
}
