package com.nf.wanjiamall.vo;

import com.nf.wanjiamall.entity.GoodsEntity;
import com.nf.wanjiamall.entity.TopicEntity;
import lombok.Data;

import java.util.List;

@Data
public class TopicGoodVo {
    TopicEntity topic;
    List<GoodsEntity> goods;
}
