package com.nf.wanjiamall.vo.wx;

import com.nf.wanjiamall.entity.AdvertisingEntity;
import com.nf.wanjiamall.entity.BrandEntity;
import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.vo.CategoryVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lzn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxHomeVo {
    //广告表信息
    private List<AdvertisingEntity> advertise;
    //商品类目表
    private List<CategoryVo> category;
    //品牌表
    private List<BrandEntity> brand;
    //商品表
    private List<GoodsEntity> goods;
    //优惠劵表

    //专题表

}
