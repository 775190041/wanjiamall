package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.*;
import com.nf.wanjiamall.entity.*;
import com.nf.wanjiamall.service.CategoryService;
import com.nf.wanjiamall.service.CouponService;
import com.nf.wanjiamall.service.TopicService;
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
    @Autowired
    CategoryServiceImpl categoryService;
    @Autowired
    private CouponDao couponDao;
    @Autowired
    private TopicDao topicDao;

    @Override
    public Object getHomeData(Integer pageNum,Integer pageSize) {
        List<AdvertisingEntity> advertisingEntities=advertisingDao.getAll(pageNum,pageSize);
        List<CategoryVo> categoryEntities= categoryService.getAll();
        List<BrandEntity> brandEntities=brandDao.getAll();
        List<GoodsEntity> goodsEntities=goodsDao.getAll();
        List<CouponEntity> couponEntities=couponDao.getAll(pageNum, pageSize);
        List<TopicEntity> topicEntities=topicDao.getAll(pageNum, pageSize);

        WxHomeVo vo = new WxHomeVo();
        vo.setAdvertise(advertisingEntities);
        vo.setCategory(categoryEntities);
        vo.setBrand(brandEntities);
        vo.setGoods(goodsEntities);
        vo.setCoupon(couponEntities);
        vo.setTopic(topicEntities);

        return ResponseUtil.ok(vo);
    }
}
