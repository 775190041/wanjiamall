package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.FootprintEntity;
import com.nf.wanjiamall.entity.vo.FootprintGoodsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
 */
public interface FootprintDao {

    List<FootprintEntity> getFootprintList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                                         @Param("footprintEntity") FootprintEntity footprintEntity);

    /**
     * 跟据用户id查询所有用户足迹
     */
    List<FootprintGoodsVo> getUserIdSelectUserFootprint(Integer userId);

    /**
     * 根据用户id批量删除用户足迹
     */
    int deleteBatchUserFootprint (Integer userId, Integer[] ids);

}
