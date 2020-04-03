package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.CategoryDao;
import com.nf.wanjiamall.dao.GoodsDao;
import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.service.wx.WxCateGoodsService;
import com.nf.wanjiamall.service.wx.WxHomeCateService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.wx.WxCateGoodsVo;
import com.nf.wanjiamall.vo.wx.WxHomeCateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lzn123
 */
@Service
@Slf4j
public class WxCateGoodsServiceImpl implements WxCateGoodsService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Object getCateGoodsData(Integer pageNum,Integer pageSize,Integer firstCateId) {
        CategoryEntity firstCate= categoryDao.cateEntity(firstCateId);
        List<CategoryEntity> secondCate= categoryDao.getSecondCate(firstCateId);
        List<GoodsEntity> goodsEntities=null;

        Object[][] obj  = new Object[secondCate.size()][];
        int i=0;
        for (CategoryEntity second : secondCate) {
            goodsEntities=goodsDao.getGoodsById(pageNum, pageSize, second.getId());
            obj[i]= goodsEntities.toArray();
            i++;
        }

        WxCateGoodsVo vo =new WxCateGoodsVo();
        vo.setFirst(firstCate);
        vo.setSecond(secondCate);
        vo.setGoodsMap(obj);
        return ResponseUtil.ok(vo);
    }

}
