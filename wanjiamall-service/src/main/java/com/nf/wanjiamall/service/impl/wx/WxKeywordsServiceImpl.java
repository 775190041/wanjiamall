package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.CategoryDao;
import com.nf.wanjiamall.dao.GoodsDao;
import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.service.wx.WxKeywordsService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.wx.WxKeywordsGoodsVo;
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
public class WxKeywordsServiceImpl implements WxKeywordsService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Object getKeywordsData(Integer pageNum, Integer pageSize, String keywords) {
        List<GoodsEntity> keywordsGoods=goodsDao.getByKeywords(pageNum,pageSize,keywords);
        List<GoodsEntity> keywordsGoodsLowToUp=goodsDao.keywordsGoodsLowToUp(pageNum, pageSize, keywords);
        List<GoodsEntity> keywordsGoodsUpToLow=goodsDao.keywordsGoodsUpToLow(pageNum, pageSize, keywords);
        List<CategoryEntity> category=categoryDao.getKeyCate(1,8,keywords);
        List<GoodsEntity> keywordsGoodsByCate=null;
        Map<String,List<GoodsEntity>> map=new HashMap<>();
        for (CategoryEntity categoryEntity : category) {
            keywordsGoodsByCate=goodsDao.keywordsGoodsByCate(pageNum, pageSize, keywords, categoryEntity.getId());
            map.put(categoryEntity.getName(),keywordsGoodsByCate);
        }

        WxKeywordsGoodsVo vo=new WxKeywordsGoodsVo();
        vo.setKeywordsGoods(keywordsGoods);
        vo.setKeywordsGoodsLowToUp(keywordsGoodsLowToUp);
        vo.setKeywordsGoodsUpToLow(keywordsGoodsUpToLow);
        vo.setCategory(category);
        vo.setKeywordsGoodsByCateMap(map);

        return ResponseUtil.ok(vo);
    }
}
