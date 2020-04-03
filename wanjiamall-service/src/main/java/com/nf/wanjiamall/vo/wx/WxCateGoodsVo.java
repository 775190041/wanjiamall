package com.nf.wanjiamall.vo.wx;

import com.nf.wanjiamall.entity.CategoryEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author lzn
 */
@Data
public class WxCateGoodsVo {
    private CategoryEntity first;

    private List<CategoryEntity> second;

    private Object[][] goodsMap;
}
