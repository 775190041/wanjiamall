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
public class WxHomeCateVo {
    //一级类目
    private List<CategoryEntity> firstCate;
    //二级类目
    private List<CategoryEntity> secondCate;
    //二级类目下的所有商品
    private Map<String,List<GoodsEntity>> secondCateGoodsMap;

}
