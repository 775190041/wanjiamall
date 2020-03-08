package com.nf.wanjiamall.service.wx;

import com.nf.wanjiamall.entity.FootprintEntity;

import java.util.List;

/**
 * 微信 用户足迹业务层
 */
public interface WxFootprintService {

    /**
     * 跟据用户id查询用户足迹
     */
    Object getUserIdSelectUserFootprint(Integer userId);

    /**
     * 根据用户id批量删除用户足迹
     */
    Object deleteBatchUserFootprint(Integer userId, Integer[] ids);
}
