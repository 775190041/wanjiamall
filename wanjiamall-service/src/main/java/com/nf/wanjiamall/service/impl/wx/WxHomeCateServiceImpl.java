package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.CategoryDao;
import com.nf.wanjiamall.dao.GoodsDao;
import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.service.wx.WxHomeCateService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.wx.WxHomeCateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn123
 */
@Service
@Slf4j
public class WxHomeCateServiceImpl implements WxHomeCateService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Object getCateData(Integer pageNum,Integer pageSize,Integer firstCateId) {
        List<CategoryEntity> firstCate= categoryDao.getFirstCate(1,8);
        List<CategoryEntity> secondCate= categoryDao.getSecondCate(firstCateId);
        List<CategoryEntity> cateEntities=categoryDao.cateEntity(firstCateId);


        WxHomeCateVo vo =new WxHomeCateVo();
        vo.setFirstCate(firstCate);
        vo.setSecondCate(secondCate);
        vo.setCateEntities(cateEntities);
        return ResponseUtil.ok(vo);
    }

}
