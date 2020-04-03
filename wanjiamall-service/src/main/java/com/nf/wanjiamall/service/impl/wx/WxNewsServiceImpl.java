package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.CategoryDao;
import com.nf.wanjiamall.dao.GoodsDao;
import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.service.wx.WxNewsService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.wx.WxNewGoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author lzn
 */
@Service
@Slf4j
public class WxNewsServiceImpl implements WxNewsService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Object getNewsData(Integer pageNum, Integer pageSize) {
        List<GoodsEntity> newGoods=goodsDao.getNewGoods(pageNum, pageSize);
        List<GoodsEntity> newGoodsLowToUp=goodsDao.newGoodsLowToUp(pageNum, pageSize);
        List<GoodsEntity> newGoodsUpToLow=goodsDao.newGoodsUpToLow(pageNum, pageSize);
        List<CategoryEntity> categoryEntities=categoryDao.getNewsCate(1, 8);
        Set<CategoryEntity> category=new HashSet<>();
        List<GoodsEntity> newGoodsByCate=null;
//        Map<String,List<GoodsEntity>> map=new HashMap<>();
//        for (CategoryEntity categoryEntity : categoryEntities) {
//            category.add(categoryEntity.getName());
//            newGoodsByCate=goodsDao.newGoodsByCate(pageNum, pageSize, categoryEntity.getId());
//            map.put(categoryEntity.getName(),newGoodsByCate);
//        \

        for (CategoryEntity categoryEntity : categoryEntities) {
            category.add(categoryEntity);
        }
        Object[][] obj  = new Object[category.size()][];
        int i=0;
        for (CategoryEntity cate : category) {
            newGoodsByCate=goodsDao.newGoodsByCate(pageNum, pageSize, cate.getId());
            obj[i]= newGoodsByCate.toArray();
            i++;
        }

        WxNewGoodsVo vo=new WxNewGoodsVo();
        vo.setNewGoods(newGoods);
        vo.setNewGoodsLowToUp(newGoodsLowToUp);
        vo.setNewGoodsUpToLow(newGoodsUpToLow);
        vo.setCategory(category);
        vo.setNewGoodsByCateMap(obj);

        return ResponseUtil.ok(vo);
    }

//    public  Object[] getMapKeyValue(Map map) {
//        Object[] object = null;
//        if ((map != null) && (!map.isEmpty())) {
//            int size = map.size();
//            object = new Object[size];
//            Iterator iterator = map.entrySet().iterator();
//            for (int i = 0; i < size; i++) {
//                Map.Entry entry = (Map.Entry) iterator.next();
//                Object key = entry.getKey();
//                Object value = entry.getValue();
////                object[i][0] = key;
//                object[i] = value;
//            }
//        }
//        return object;
//    }
}
