package com.nf.wanjiamall.vo.wx;

import com.nf.wanjiamall.entity.BrandEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import lombok.Data;

import java.util.List;

/**
 * @author lzn
 */
@Data
public class WxBrandGoodVo {
    //本品牌信息
    private BrandEntity brand;
    //该品牌下的商品信息
    private List<GoodsEntity> goods;
}
