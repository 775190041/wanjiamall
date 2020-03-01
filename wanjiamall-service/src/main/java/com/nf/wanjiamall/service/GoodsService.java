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
    Object listGoods(int pageNum,int pageSize,int id,String goodsSn,String name);

}
