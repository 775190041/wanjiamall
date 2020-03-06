package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.*;
import com.nf.wanjiamall.entity.*;
import com.nf.wanjiamall.service.wx.WxHomeService;
import com.nf.wanjiamall.utils.ResponseUtil;
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
    private CategoryDao categoryDao;
    @Autowired
    private CouponDao couponDao;
    @Autowired
    private TopicDao topicDao;

    @Override
    public Object getHomeData() {
        List<AdvertisingEntity> advertisingEntities=advertisingDao.getAll();
        List<CategoryEntity> firstCate= categoryDao.getFirstCate();
        List<BrandEntity> brandEntities=brandDao.getAll();
        List<GoodsEntity> newGoods=goodsDao.getNewGoods();
        List<GoodsEntity> hotGoods=goodsDao.getHotGoods();
        List<CouponEntity> couponEntities=couponDao.getAll();
        List<TopicEntity> topicEntities=topicDao.getAll();

        WxHomeVo vo =new WxHomeVo();
        vo.setAdvertise(advertisingEntities);
        vo.setFirstCate(firstCate);
        vo.setBrand(brandEntities);
        vo.setNewGoods(newGoods);
        vo.setHotGoods(hotGoods);
        vo.setCoupon(couponEntities);
        vo.setTopic(topicEntities);

        return ResponseUtil.ok(vo);
    }

    @Override
    public Object getCateData(Integer pid) {
        List<CategoryEntity> secondCate= categoryDao.getSecondCate(pid);

        WxHomeVo vo =new WxHomeVo();
        vo.setSecondCate(secondCate);
        return ResponseUtil.ok(vo);
    }
}
