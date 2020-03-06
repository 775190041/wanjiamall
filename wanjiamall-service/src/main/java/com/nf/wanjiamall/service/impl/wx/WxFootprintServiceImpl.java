package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.FootprintDao;
import com.nf.wanjiamall.entity.FootprintEntity;
import com.nf.wanjiamall.service.wx.WxFootprintService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.entity.vo.FootprintGoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信 用户业务实现层
 */
@Service
@Slf4j
public class WxFootprintServiceImpl implements WxFootprintService {

    @Autowired
    private FootprintDao footprintDao;

    /**
     * 跟据用户id查询用户足迹
     */
    @Override
    public Object getUserIdSelectUserFootprint(Integer userId) {
        /**
         *      //做登录之后判断当前用户 与  足迹用户是否是同一个用户
         *      if(userId.equals(footprintEntity.getUserId())){
         *        }
         */
        //还没做登录得先判断不能为空。
        if(userId == null){
            return ResponseUtil.fail(501,"请登录");
        }{
            /**查询当前用户所有足迹*/
            List<FootprintGoodsVo> footprintEntityList = footprintDao.getUserIdSelectUserFootprint(userId);

            /** 用户浏览过多少样商品 */
            List<Object> footprintGoods = new ArrayList<>(footprintEntityList.size());

            /**循环所有用户足迹*/
            for (FootprintGoodsVo list : footprintEntityList){
                /**
                 * 足迹信息
                 */
                Map<String,Object> map = new HashMap<>(16);
                map.put("id", list.getId());
                map.put("goodsId", list.getGoodsId());
                map.put("addTime", list.getAddTime());
                /**
                 * 商品信息
                 */
                map.put("name", list.getName());
                map.put("brief", list.getBrief());
                map.put("picUrl", list.getPicUrl());
                map.put("retailPrice", list.getRetailPrice());

                /** 每样商品浏览信息存储 */
                footprintGoods.add(map);
            }
            return  ResponseUtil.ok(footprintGoods);

        }
    }

    @Transactional
    @Override
    public Object deleteBatchUserFootprint(Integer userId, Integer[] ids) {
        if(userId != null){
            if(footprintDao.deleteBatchUserFootprint(userId,ids) > 0){
                log.debug("删除用户足迹的个数："+ ids.length);
                return ResponseUtil.ok();
            }else{
                return ResponseUtil.fail(505,"删除失败！");
            }
        }else{
            return ResponseUtil.fail(501,"请登录!");
        }


    }
}
