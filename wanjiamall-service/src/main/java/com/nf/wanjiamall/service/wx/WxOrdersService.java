package com.nf.wanjiamall.service.wx;

/**
 * wx 我的订单服务
 */
public interface WxOrdersService {

    /**
     *  订单列表
     */
    Object getQueryAllOrders(Integer pageNum, Integer pageSize , Integer userId, Integer showType);

    /**
     * 订单详情
     */
    Object orderDetail(Integer userId,Integer orderId);

    /**
     * 提交订单
     */
    Object orderSubmit(Integer userId,String body);

    /**
     * 订单支付失败或者成功回调
     */
    Object orderCallback();

    /**
     * 订单申请退款
     */
    Object orderRefund(Integer userId,String body);

    /**
     * 确认收货
     */
    Object orderConfirm(Integer userId,String body);

    /**
     * 删除订单
     */
    Object orderDelete(Integer userId,String body);

    /**
     *待评价订单商品信息
     */
    Object orderGoods(Integer userId,Integer orderId,Integer goodsId);

    /**
     * 评价订单商品
     */
    Object orderComment(Integer userId,String body);

}
