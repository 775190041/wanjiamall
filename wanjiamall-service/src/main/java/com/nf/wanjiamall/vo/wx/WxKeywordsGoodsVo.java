package com.nf.wanjiamall.vo.wx;

import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author lzn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxKeywordsGoodsVo {
    //综合
    private List<GoodsEntity> keywordsGoods;
    //根据价格升序
    private List<GoodsEntity> keywordsGoodsLowToUp;
    //根据价格降序
    private List<GoodsEntity> keywordsGoodsUpToLow;
    //根据分类
    private List<CategoryEntity> category;
    private Map<String,List<GoodsEntity>> keywordsGoodsByCateMap;

}
