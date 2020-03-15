package com.nf.wanjiamall.vo.wx;

import com.nf.wanjiamall.entity.*;
import lombok.Data;

import java.util.List;

/**
 * @author lzn
 */
@Data
public class WxGoodInfoVo {
    //商品信息
    private GoodsEntity goods;
    //品牌
    private BrandEntity brand;
    //规格
    private List<GoodsProductEntity> productList;
    //参数
    private List<GoodsAttributeEntity> attributeList;
    //通用问题
    private List<IssueEntity> issueList;
    //收藏
    private Boolean collect;



}
