package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.BrandDao;
import com.nf.wanjiamall.dao.CategoryDao;
import com.nf.wanjiamall.dao.GoodsDao;
import com.nf.wanjiamall.entity.BrandEntity;
import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.service.wx.WxBrandService;
import com.nf.wanjiamall.service.wx.WxNewsService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.wx.WxBrandVo;
import com.nf.wanjiamall.vo.wx.WxNewGoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<CategoryEntity> category=categoryDao.getNewsCate(1, 8);
        List<GoodsEntity> newGoodsByCate=null;
        Map<String,List<GoodsEntity>> map=new HashMap<>();
        for (CategoryEntity categoryEntity : category) {
            newGoodsByCate=goodsDao.newGoodsByCate(pageNum, pageSize, categoryEntity.getId());
            map.put(categoryEntity.getName(),newGoodsByCate);
        }

        WxNewGoodsVo vo=new WxNewGoodsVo();
        vo.setNewGoods(newGoods);
        vo.setNewGoodsLowToUp(newGoodsLowToUp);
        vo.setNewGoodsUpToLow(newGoodsUpToLow);
        vo.setCategory(category);
        vo.setNewGoodsByCateMap(map);

        return ResponseUtil.ok(vo);
    }
}
