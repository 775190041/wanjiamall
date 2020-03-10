package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.CategoryDao;
import com.nf.wanjiamall.dao.GoodsDao;
import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.service.wx.WxHomeCateService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.wx.WxHomeCateVo;
import com.nf.wanjiamall.vo.wx.WxHomeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * @author lzn
 */
@Service
@Slf4j
public class WxHomeCateServiceImpl implements WxHomeCateService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Object getCateData(Integer pageNum,Integer pageSize,Integer firstCateId) {
        List<CategoryEntity> firstCate= categoryDao.getFirstCate(1,8);
        List<CategoryEntity> secondCate= categoryDao.getSecondCate(firstCateId);

        List<GoodsEntity> secondCateGoods= null;
        Map<String,List<GoodsEntity>> secondCateGoodsMap=new HashMap<>();
        for (CategoryEntity categoryEntity : secondCate) {
            secondCateGoods=goodsDao.getGoodsById(pageNum, pageSize, categoryEntity.getId());
            secondCateGoodsMap.put(categoryEntity.getName(),secondCateGoods);
        }

        WxHomeCateVo vo =new WxHomeCateVo();
        vo.setFirstCate(firstCate);
        vo.setSecondCate(secondCate);
        vo.setSecondCateGoodsMap(secondCateGoodsMap);
        return ResponseUtil.ok(vo);
    }

}
