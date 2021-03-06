package com.nf.wanjiamall.vo.wx;
import com.nf.wanjiamall.entity.AdvertisingEntity;
import com.nf.wanjiamall.entity.BrandEntity;
import com.nf.wanjiamall.entity.*;
import com.nf.wanjiamall.vo.CategoryVo;
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
public class WxHomeVo {
    //广告表信息
    private List<AdvertisingEntity> advertise;
    //一级类目
    private List<CategoryEntity> firstCate;
    //一级类目下的所有商品
    private Map<String,List<GoodsEntity>> firstCateGoodsMap;
    //品牌表
    private List<BrandEntity> brand;
    //新品
    private List<GoodsEntity> newGoods;
    //热气推荐
    private List<GoodsEntity> hotGoods;
    //优惠劵表
    private List<CouponEntity> coupon;
    //专题表
    private List<TopicEntity> topic;

}
