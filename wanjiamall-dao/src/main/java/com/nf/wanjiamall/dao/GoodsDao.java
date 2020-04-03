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
     *  新品(详情)
     */
    List<GoodsEntity> getNewGoods(@Param("pageNum") Integer pageNum,
                                  @Param("pageSize") Integer pageSize);

    List<GoodsEntity> newGoodsLowToUp(@Param("pageNum") Integer pageNum,
                                      @Param("pageSize") Integer pageSize);

    List<GoodsEntity> newGoodsUpToLow(@Param("pageNum") Integer pageNum,
                                      @Param("pageSize") Integer pageSize);

    List<GoodsEntity> newGoodsByCate(@Param("pageNum") Integer pageNum,
                                     @Param("pageSize") Integer pageSize,
                                     @Param("cateId") Integer cateId);

    /**
     *  人气（详情）
     */
    List<GoodsEntity> getHotGoods(@Param("pageNum") Integer pageNum,
                                  @Param("pageSize") Integer pageSize);

    List<GoodsEntity> hotGoodsLowToUp(@Param("pageNum") Integer pageNum,
                                      @Param("pageSize") Integer pageSize);

    List<GoodsEntity> hotGoodsUpToLow(@Param("pageNum") Integer pageNum,
                                      @Param("pageSize") Integer pageSize);

    List<GoodsEntity> hotGoodsByCate(@Param("pageNum") Integer pageNum,
                                     @Param("pageSize") Integer pageSize,
                                     @Param("cateId") Integer cateId);

    /**
     *  关键字搜索（详情）
     */
    List<GoodsEntity> getByKeywords(@Param("pageNum") Integer pageNum,
                                    @Param("pageSize") Integer pageSize,
                                    @Param("keywords") String keyword);

    List<GoodsEntity> keywordsGoodsLowToUp(@Param("pageNum") Integer pageNum,
                                      @Param("pageSize") Integer pageSize,
                                      @Param("keywords") String keywords);

    List<GoodsEntity> keywordsGoodsUpToLow(@Param("pageNum") Integer pageNum,
                                      @Param("pageSize") Integer pageSize,
                                      @Param("keywords") String keywords);

    List<GoodsEntity> keywordsGoodsByCate(@Param("pageNum") Integer pageNum,
                                     @Param("pageSize") Integer pageSize,
                                     @Param("keywords") String keywords,
                                     @Param("cateId") Integer cateId);

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
     * @return1
     */
    List<GoodsEntity> getGoodsById(@Param("pageNum") Integer pageNum,
                                   @Param("pageSize") Integer pageSize,
                                   @Param("cateId") Integer cateId);

    /**
     * 获取品牌的商品
     * @param pageNum
     * @param pageSize
     * @param brandId
     * @return
     */
    List<GoodsEntity> getByBrandId(@Param("pageNum") Integer pageNum,
                                   @Param("pageSize") Integer pageSize,
                                   @Param("brandId") Integer brandId);

    /**
     * 根据商品id查询商品信息
     */
    GoodsEntity GoodsById(@Param("id") int id);

    /**
     * 判断商品编号和商品名称是否存在
     */
    Integer checkExistByNameOrGoodsSn(@Param("goodsSn") String goodsSn,@Param("name") String Name);

    GoodsEntity getGoodById(@Param("goodsId") String goodsId);
}
