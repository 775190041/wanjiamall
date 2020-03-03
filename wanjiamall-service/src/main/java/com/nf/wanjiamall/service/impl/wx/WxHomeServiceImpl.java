package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.AdvertisingDao;
import com.nf.wanjiamall.dao.BrandDao;
import com.nf.wanjiamall.dao.GoodsDao;
import com.nf.wanjiamall.entity.AdvertisingEntity;
import com.nf.wanjiamall.entity.BrandEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.service.impl.CategoryServiceImpl;
import com.nf.wanjiamall.service.wx.WxHomeService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.CategoryVo;
import com.nf.wanjiamall.vo.wx.WxHomeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
@Slf4j
public class WxHomeServiceImpl implements WxHomeService {
    @Autowired
    private AdvertisingDao advertisingDao;
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Object getHomeData(Integer pageNum,Integer pageSize) {
        CategoryServiceImpl categoryService=new CategoryServiceImpl();
        List<AdvertisingEntity> advertisingEntities=advertisingDao.getAll(pageNum,pageSize);
        List<CategoryVo> categoryEntities= categoryService.getAll();
        List<BrandEntity> brandEntities=brandDao.getAll();
        List<GoodsEntity> goodsEntities=goodsDao.getAll();

        WxHomeVo vo = new WxHomeVo();
        vo.setAdvertise(advertisingEntities);
        vo.setCategory(categoryEntities);
        vo.setBrand(brandEntities);
        vo.setGoods(goodsEntities);

        return ResponseUtil.ok(vo);
    }
}
