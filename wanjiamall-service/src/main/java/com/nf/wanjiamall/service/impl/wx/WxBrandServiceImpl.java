package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.BrandDao;
import com.nf.wanjiamall.dao.GoodsDao;
import com.nf.wanjiamall.entity.BrandEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.service.wx.WxBrandService;
import com.nf.wanjiamall.utils.ResponseUtil;
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
public class WxBrandServiceImpl implements WxBrandService {
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Object getBrandData(Integer pageNum, Integer pageSize) {
        List<BrandEntity> brandEntities=brandDao.getAll();
        List<GoodsEntity> goodsEntities=null;
        Map<String,List<GoodsEntity>> map=new HashMap<>();
        for (BrandEntity brandEntity : brandEntities) {
            goodsEntities=goodsDao.getByBrandId(pageNum,pageSize,brandEntity.getId());
            map.put(brandEntity.getName(),goodsEntities);
        }

        WxBrandVo vo=new WxBrandVo();
        vo.setBrands(brandEntities);
        vo.setGoodsMap(map);

        return ResponseUtil.ok(vo);
    }
}
