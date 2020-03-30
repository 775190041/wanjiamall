package com.nf.wanjiamall.vo.wx;

import com.nf.wanjiamall.entity.BrandEntity;
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
public class WxBrandVo {
    //品牌信息
    private List<BrandEntity> brands;
}
