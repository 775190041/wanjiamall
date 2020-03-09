package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.GoodsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {
    /**
     * 上架商品，
     */
    int insert(@Param("goodsEntity") GoodsEntity goodsEntity);

    /**
     * 修改商品
     */
    int update(@Param("goods") GoodsEntity goodsEntity);

    /**
     * 删除商品
     */
    int delete(@Param("id") int id);

    /**
     * 查询全部商品
     * @param pageNum
     * @param pageSize
     * @param id
     * @param goodsSn
     * @param name
     * @return
     */
    List<GoodsEntity> listGoods(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize,@Param("id") Integer id,@Param("goodsSn") String goodsSn, @Param("name") String name);

    /**
     *  新品
     */
    List<GoodsEntity> getNewGoods();

    /**
     *  人气
     */
    List<GoodsEntity> getHotGoods();

    /**
     * 获取一级类目下的所有商品信息
     * @param pageNum
     * @param pageSize
     * @param cateId
     * @return
     */
    List<GoodsEntity> getByCateId(@Param("pageNum") Integer pageNum,
                                  @Param("pageSize") Integer pageSize,
                                  @Param("cateId") Integer cateId);

    /**
     * 获取二级类目下的所有商品信息
     * @param pageNum
     * @param pageSize
     * @param cateId
     * @return
     */
    List<GoodsEntity> getGoodsById(@Param("pageNum") Integer pageNum,
                                  @Param("pageSize") Integer pageSize,
                                  @Param("cateId") Integer cateId);


    /**
     * 根据商品id查询商品信息
     */
    GoodsEntity GoodsById(@Param("id") int id);

}
