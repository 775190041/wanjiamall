package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.*;
import com.nf.wanjiamall.entity.*;
import com.nf.wanjiamall.service.wx.WxGoodInfoService;
import com.nf.wanjiamall.vo.wx.WxGoodInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
@Slf4j
public class WxGoodInfoServiceImpl implements WxGoodInfoService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsProductDao goodsProductDao;
    @Autowired
    private GoodsAttributeDao attributeDao;
    @Autowired
    private IssueDao issueDao;
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private CollectDao collectDao;
    @Autowired
    private FootprintDao footprintDao;

    @Override
    public Object getGoodInfoData(Integer goodId,Integer userId) {
        GoodsEntity goodsEntity=goodsDao.GoodsById(goodId);
        List<GoodsProductEntity> goodsProductList=goodsProductDao.listByGoodsId(goodId);
        List<GoodsAttributeEntity> attributeList=attributeDao.listGoodsById(goodId);
        List<IssueEntity> issueList=issueDao.getAll();
        BrandEntity brandEntity=brandDao.getByGoodId(goodId);
        Integer num=collectDao.getCount(goodId,userId);
        FootprintEntity footprintEntity=new FootprintEntity();
        footprintEntity.setGoodsId(goodId);
        footprintEntity.setUserId(userId);
        footprintDao.insert(footprintEntity);

        WxGoodInfoVo vo=new WxGoodInfoVo();
        vo.setGoods(goodsEntity);
        vo.setProductList(goodsProductList);
        vo.setAttributeList(attributeList);
        vo.setIssueList(issueList);
        vo.setBrand(brandEntity);
        if(num==1){
            vo.setCollect(true);
        }else {
            vo.setCollect(false);
        }
        return vo;
    }
}
