package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.FootprintEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
 */
public interface FootprintDao {
    List<FootprintEntity> getFootprintList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                                         @Param("footprintEntity") FootprintEntity footprintEntity);
}
