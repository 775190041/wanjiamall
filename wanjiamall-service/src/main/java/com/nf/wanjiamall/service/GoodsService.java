package com.nf.wanjiamall.service;

import com.nf.wanjiamall.vo.AddGoodsVo;

public interface GoodsService {

/**
 * 商品上架
 */
    Object AddGoods(AddGoodsVo addGoodsVo);

    /**
     *编辑商品
     */
    Object updateGoods(AddGoodsVo addGoodsVo);

    /**
     * 商品删除
     */
    Object delete(int id);

    /**
     * 查询所有商品
     */
    Object listGoods(int pageNum,int pageSize,Integer id,String goodsSn,String name);

    /**
     * 查询某个商品的详细信息
     */
    Object queryGoodsDetail(int id);


    /**
     * 查询品牌商和类目
     */
    Object listBrandCategory();


    /**
     *
     *删除参数
     */
    Object deleteAttribute(Integer id);

}
