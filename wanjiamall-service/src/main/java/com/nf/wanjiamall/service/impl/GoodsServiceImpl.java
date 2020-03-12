package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.*;
import com.nf.wanjiamall.entity.*;
import com.nf.wanjiamall.service.GoodsService;
import com.nf.wanjiamall.utils.ArrayUtils;
import com.nf.wanjiamall.utils.ResponseCode;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.AddGoodsVo;
import com.nf.wanjiamall.vo.CatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired(required = false)
    private GoodsDao goodsDao;
    @Autowired(required = false)
    private GoodsSpecificationDao goodsSpecificationDao;
    @Autowired(required = false)
    private GoodsProductDao goodsProductDao;
    @Autowired(required = false)
    private GoodsAttributeDao goodsAttributeDao;
    @Autowired(required = false)
    private CategoryDao categoryDao;
    @Autowired(required = false)
    private BrandDao brandDao;


    /**
     * 上架商品
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
        //把数组转变为字符串加双引号
        String gallery = ArrayUtils.addDouble( goodsEntity.getGallery());
        goodsEntity.setGallerys(gallery);
         //判断该商品是否存在和商品编号是否存在
         String goodsSn = goodsEntity.getGoodsSn();
         String name = goodsEntity.getName();
        if (goodsDao.checkExistByNameOrGoodsSn(goodsSn,name) >0){
            return ResponseUtil.fail(611,"商品或编号存在");
        }
        //取产品的最低价格录入到零售价格去
        Double retailPrice = new Double(Integer.MAX_VALUE);
        for (GoodsProductEntity goodsProductEntity : goodsProductEntities) {
                Double price = goodsProductEntity.getPrice();
                if (retailPrice.compareTo(price) ==1){
                    retailPrice = price;
                }
        }
        //把最低的零售价格放进去
        goodsEntity.setRetailPrice(retailPrice);
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
            //把数组转变为字符串
            String specifications = ArrayUtils.addDouble(goodsProductEntity.getSpecifications());
            goodsProductEntity.setSpecification(specifications);
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
        //把数组转变为字符串
        String gallery = ArrayUtils.addDouble(goodsEntity.getGallery());
        goodsEntity.setGallerys(gallery);

        //判断该商品是否存在和商品编号是否存在
        String goodsSn = goodsEntity.getGoodsSn();
        String name = goodsEntity.getName();
        if (goodsDao.checkExistByNameOrGoodsSn(goodsSn,name) >0){
            return ResponseUtil.fail(611,"商品或编号存在,修改失败");
        }
        //商品基本信息表
        goodsDao.update(goodsEntity);
        //商品规格表
        for (GoodsSpecificationEntity goodsSpecificationEntity : goodsSpecificationEntities) {
            goodsSpecificationDao.update(goodsSpecificationEntity);
        }
        //商品货物表
        for (GoodsProductEntity goodsProductEntity : goodsProductEntities) {
            //把数组转变为字符串
            String specifications = ArrayUtils.addDouble(goodsProductEntity.getSpecifications());
            goodsProductEntity.setSpecification(specifications);
            goodsProductDao.update(goodsProductEntity);
        }
        //参数表
        for (GoodsAttributeEntity goodsAttributeEntity : goodsAttributeEntities) {
            if (goodsAttributeEntity.getId() == null){
                goodsAttributeEntity.setGoodsId(goodsEntity.getId());
                goodsAttributeDao.insert(goodsAttributeEntity);
            }else {
                goodsAttributeDao.update(goodsAttributeEntity);
            }
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
        //查询类目表的的id
        CategoryEntity categoryEntity = categoryDao.getByIdDetail(goodsEntity.getCategoryId());



        Map<String, Object> data = new HashMap<>();
        data.put("goods",goodsEntity);
        data.put("goodsSpec",goodsSpecificationEntities);
        data.put("goodsProduct",goodsProductEntities);
        data.put("goodsAttribute",goodsAttributeEntities);
        Integer[] integers = new Integer[]{categoryEntity.getPid(),categoryEntity.getId()};
        data.put("categoryIds",integers);

        return ResponseUtil.ok(data);
    }

    /**
     * 查询品牌商品和类目
     * @return
     */
    @Override
    public Object listBrandCategory() {
        //类目查询放入CatVo类
        List<CategoryEntity> l1categoryEntities =categoryDao.getFirstCate(1,Integer.MAX_VALUE);
        List<CatVo> categoryList = new ArrayList<>(l1categoryEntities.size());
        for (CategoryEntity categoryEntity : l1categoryEntities) {
            CatVo l1CatVo = new CatVo();
            l1CatVo.setValue(categoryEntity.getId());
            l1CatVo.setLabel(categoryEntity.getName());


            List<CategoryEntity> l2categoryEntities = categoryDao.getSecondCate(categoryEntity.getId());
            List<CatVo> children = new ArrayList<>(l2categoryEntities.size());
            for (CategoryEntity l2categoryEntity : l2categoryEntities) {
                CatVo l2CatVo = new CatVo();
                l2CatVo.setValue(l2categoryEntity.getId());
                l2CatVo.setLabel(l2categoryEntity.getName());
                children.add(l2CatVo);
            }
            l1CatVo.setChildren(children);
            categoryList.add(l1CatVo);
        }
        //品牌查询放入CatVo类
        List<BrandEntity> list = brandDao.getAll();
        List<Map<String,Object>> brandList = new ArrayList<>(list.size());

        for (BrandEntity brandEntity : list) {
            Map<String,Object> brand = new HashMap<>(2);
            brand.put("value",brandEntity.getId());
            brand.put("label",brandEntity.getName());
            brandList.add(brand);
        }
        Map<String,Object> date = new HashMap<>();
        date.put("categoryList",categoryList);
        date.put("brandList",brandList);
        return ResponseUtil.ok(date);
    }

    @Override
    public Object deleteAttribute(Integer id) {
        Integer count = goodsAttributeDao.deleteAttribute(id);
        if (count>0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"参数删除失败");
        }

    }
}
