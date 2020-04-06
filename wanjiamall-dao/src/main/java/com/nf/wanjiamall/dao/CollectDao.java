package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.CollectEntity;
import com.nf.wanjiamall.entity.GoodsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
 */
public interface CollectDao{
    List<CollectEntity> getCollectList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                                       @Param("collectEntity") CollectEntity collectEntity);
    List<CollectEntity> getCollectByUserId(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                                       @Param("userId") Integer userId);
    CollectEntity getCollectInsertAndDelete(@Param("userId") Integer userId,@Param("goodsId") Integer goodsId);
    int collectInsert(@Param("userId") Integer userId,@Param("goodsId") Integer goodsId);
    int collectDelete(@Param("userId") Integer userId,@Param("goodsId") Integer goodsId);

    Integer getCount(@Param("goodId") Integer goodId,@Param("userId") Integer userId);
}
