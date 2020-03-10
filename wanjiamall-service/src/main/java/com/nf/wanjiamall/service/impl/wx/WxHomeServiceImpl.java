package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.*;
import com.nf.wanjiamall.entity.*;
import com.nf.wanjiamall.service.wx.WxHomeService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.wx.WxHomeVo;
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
    public Object getHomeData(Integer pageNum,Integer pageSize) {
        List<AdvertisingEntity> advertisingEntities=advertisingDao.getAll();
        List<CategoryEntity> firstCate= categoryDao.getFirstCate(pageNum, pageSize);
        List<BrandEntity> brandEntities=brandDao.getAll();
        List<GoodsEntity> newGoods=goodsDao.getNewGoods(1,6);
        List<GoodsEntity> hotGoods=goodsDao.getHotGoods(1,6);
        List<CouponEntity> couponEntities=couponDao.getAll();
        List<TopicEntity> topicEntities=topicDao.getAll();

        List<GoodsEntity> firstCateGoods=null;
        Map<String,List<GoodsEntity>> firstCateGoodsMap=new HashMap<>();
        for (CategoryEntity categoryEntity : firstCate) {
            firstCateGoods=goodsDao.getByCateId(1, 4, categoryEntity.getId());
            firstCateGoodsMap.put(categoryEntity.getName(),firstCateGoods);
        }

        WxHomeVo vo =new WxHomeVo();
        vo.setAdvertise(advertisingEntities);
        vo.setFirstCate(firstCate);
        vo.setBrand(brandEntities);
        vo.setNewGoods(newGoods);
        vo.setHotGoods(hotGoods);
        vo.setCoupon(couponEntities);
        vo.setTopic(topicEntities);
        vo.setFirstCateGoodsMap(firstCateGoodsMap);


        return ResponseUtil.ok(vo);
    }
}
