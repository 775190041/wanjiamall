package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.GoodsAttributeDao;
import com.nf.wanjiamall.dao.GoodsDao;
import com.nf.wanjiamall.dao.GoodsProductDao;
import com.nf.wanjiamall.dao.GoodsSpecificationDao;
import com.nf.wanjiamall.entity.GoodsAttributeEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.entity.GoodsProductEntity;
import com.nf.wanjiamall.entity.GoodsSpecificationEntity;
import com.nf.wanjiamall.service.GoodsService;
import com.nf.wanjiamall.utils.ResponseCode;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.AddGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsSpecificationDao goodsSpecificationDao;
    @Autowired
    private GoodsProductDao goodsProductDao;
    @Autowired
    private GoodsAttributeDao goodsAttributeDao;

    /**
     * 上架商品
     * 还缺少校验的
     * @param addGoodsVo
     * @return
     */

    @Transactional
    @Override
    public Object AddGoods(AddGoodsVo addGoodsVo) {
        GoodsEntity goodsEntity = addGoodsVo.getGoodsEntity();
        GoodsSpecificationEntity[] goodsSpecificationEntities = addGoodsVo.getGoodsSpecificationEntity();
        GoodsProductEntity[] goodsProductEntities = addGoodsVo.getGoodsProductEntities();
        GoodsAttributeEntity[] goodsAttributeEntities = addGoodsVo.getGoodsAttributeEntity();
        goodsEntity.setGallerys(Arrays.toString(goodsEntity.getGallery()));
        //商品基本信息表
        goodsDao.insert(goodsEntity);
        //商品规格表
        for (GoodsSpecificationEntity goodsSpecificationEntity : goodsSpecificationEntities) {
            goodsSpecificationEntity.setGoodsId(goodsEntity.getId());

            goodsSpecificationDao.insert(goodsSpecificationEntity);
        }
        //商品货物表
        for (GoodsProductEntity goodsProductEntity : goodsProductEntities) {
            goodsProductEntity.setGoodsId(goodsEntity.getId());
            goodsProductEntity.setSpecification(Arrays.toString(goodsProductEntity.getSpecifications()));
            goodsProductDao.insert(goodsProductEntity);
        }
        //参数表
        for (GoodsAttributeEntity goodsAttributeEntity : goodsAttributeEntities) {
            goodsAttributeEntity.setGoodsId(goodsEntity.getId());
            goodsAttributeDao.insert(goodsAttributeEntity);
        }
        return ResponseUtil.ok();
    }
    /**
     * 编辑商品
     * 这里修改商品是有问题的（待定）
     * @param addGoodsVo
     * @return
     */
    @Transactional
    @Override
    public Object updateGoods(AddGoodsVo addGoodsVo) {
        GoodsEntity goodsEntity = addGoodsVo.getGoodsEntity();
        GoodsSpecificationEntity[] goodsSpecificationEntities = addGoodsVo.getGoodsSpecificationEntity();
        GoodsProductEntity[] goodsProductEntities = addGoodsVo.getGoodsProductEntities();
        GoodsAttributeEntity[] goodsAttributeEntities = addGoodsVo.getGoodsAttributeEntity();
        //商品基本信息表
        goodsDao.update(goodsEntity);
        //商品规格表
        for (GoodsSpecificationEntity goodsSpecificationEntity : goodsSpecificationEntities) {

            goodsSpecificationDao.update(goodsSpecificationEntity);
        }
        //商品货物表
        for (GoodsProductEntity goodsProductEntity : goodsProductEntities) {

            goodsProductDao.update(goodsProductEntity);
        }
        //参数表
        for (GoodsAttributeEntity goodsAttributeEntity : goodsAttributeEntities) {

            goodsAttributeDao.update(goodsAttributeEntity);
        }
        return ResponseUtil.ok();
    }


    /**
     * 商品删除
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Object delete(int id) {

        goodsDao.delete(id);
        goodsSpecificationDao.delete(id);
        goodsProductDao.delete(id);
        goodsAttributeDao.delete(id);
        return ResponseUtil.ok();
    }

    /**
     * 查询
     * @param pageNum
     * @param pageSize
     * @param id
     * @param goodsSn
     * @param name
     * @return
     */
    @Override
    public Object listGoods(int pageNum, int pageSize, Integer id, String goodsSn, String name) {
        List<GoodsEntity> goodsEntities = goodsDao.listGoods(pageNum,pageSize,id,goodsSn,name);
        return ResponseUtil.okList(goodsEntities);
    }

    /**
     * 查询某个商品详细信息
     * @param id
     * @return
     */
    @Override
    public Object queryGoodsDetail(int id) {
        GoodsEntity goodsEntity = goodsDao.GoodsById(id);
        List<GoodsSpecificationEntity> goodsSpecificationEntities = goodsSpecificationDao.listGoodsById(id);
        List<GoodsProductEntity> goodsProductEntities = goodsProductDao.listByGoodsId(id);
        List<GoodsAttributeEntity> goodsAttributeEntities = goodsAttributeDao.listGoodsById(id);
        Map<String, Object> data = new HashMap<>();
        data.put("goods",goodsEntity);
        data.put("goodsSpec",goodsSpecificationEntities);
        data.put("goodsProduct",goodsProductEntities);
        data.put("goodsAttribute",goodsAttributeEntities);
        return ResponseUtil.ok(data);
    }
}
