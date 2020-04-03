package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.CategoryDao;
import com.nf.wanjiamall.dao.GoodsDao;
import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.service.wx.WxHotService;
import com.nf.wanjiamall.service.wx.WxNewsService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.wx.WxHotGoodsVo;
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
public class WxHotServiceImpl implements WxHotService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Object getHotData(Integer pageNum, Integer pageSize) {
        List<GoodsEntity> hotGoods=goodsDao.getHotGoods(pageNum, pageSize);
        List<GoodsEntity> hotGoodsLowToUp=goodsDao.hotGoodsLowToUp(pageNum, pageSize);
        List<GoodsEntity> hotGoodsUpToLow=goodsDao.hotGoodsUpToLow(pageNum, pageSize);
        List<CategoryEntity> categoryEntities=categoryDao.getHotCate(1,8);
        Set<CategoryEntity> category=new HashSet<>();
        List<GoodsEntity> hotGoodsByCate=null;

        for (CategoryEntity categoryEntity : categoryEntities) {
            category.add(categoryEntity);
        }
        Object[][] obj  = new Object[category.size()][];
        int i=0;
        for (CategoryEntity cate : category) {
            hotGoodsByCate=goodsDao.hotGoodsByCate(pageNum, pageSize, cate.getId());
            obj[i]= hotGoodsByCate.toArray();
            i++;
        }

        WxHotGoodsVo vo=new WxHotGoodsVo();
        vo.setHotGoods(hotGoods);
        vo.setHotGoodsLowToUp(hotGoodsLowToUp);
        vo.setHotGoodsUpToLow(hotGoodsUpToLow);
        vo.setCategory(category);
        vo.setHotGoodsByCateMap(obj);

        return ResponseUtil.ok(vo);
    }
}
