package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.BrandDao;
import com.nf.wanjiamall.dao.GoodsDao;
import com.nf.wanjiamall.entity.BrandEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.service.wx.WxBrandGoodsService;
import com.nf.wanjiamall.service.wx.WxBrandService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.wx.WxBrandGoodVo;
import com.nf.wanjiamall.vo.wx.WxBrandVo;
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
public class WxBrandGoodsServiceImpl implements WxBrandGoodsService {
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Object getBrandGoodsData(Integer pageNum, Integer pageSize,Integer brandId) {
        BrandEntity brandEntities=brandDao.getById(pageNum, pageSize, brandId);
        List<GoodsEntity> goodsEntities=goodsDao.getByBrandId(pageNum,pageSize,brandId);

        WxBrandGoodVo vo=new WxBrandGoodVo();
        vo.setBrand(brandEntities);
        vo.setGoods(goodsEntities);

        return ResponseUtil.ok(vo);
    }
}
