package com.nf.wanjiamall.utils;

import com.nf.wanjiamall.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单流程：下单成功－》支付订单－》发货－》收货
 * 订单状态：
 * 101 订单生成，未支付；102，下单未支付用户取消；103，下单未支付超期系统自动取消
 * 201 支付完成，商家未发货；202，订单生产，已付款未发货，用户申请退款；203，管理员执行退款操作，确认退款成功；
 * 301 商家发货，用户未确认；
 * 401 用户确认收货，订单结束； 402 用户没有确认收货，但是快递反馈已收货后，超过一定时间，系统自动确认收货，订单结束。
 *
 * 当101用户未付款时，此时用户可以进行的操作是取消或者付款
 * 当201支付完成而商家未发货时，此时用户可以退款
 * 当301商家已发货时，此时用户可以有确认收货
 * 当401用户确认收货以后，此时用户可以进行的操作是退货、删除、去评价或者再次购买
 * 当402系统自动确认收货以后，此时用户可以删除、去评价、或者再次购买
 */
public class OrderUtil {
    public static final Integer STATUS_CREATE = 101;
    public static final Integer STATUS_PAY = 201;
    public static final Integer STATUS_SHIP = 301;
    public static final Integer STATUS_CONFIRM = 401;
    public static final Integer STATUS_CANCEL = 102;
    public static final Integer STATUS_AUTO_CANCEL = 103;
    public static final Integer STATUS_ADMIN_CANCEL = 104;
    public static final Integer STATUS_REFUND = 202;
    public static final Integer STATUS_REFUND_CONFIRM = 203;
    public static final Integer STATUS_AUTO_CONFIRM = 402;




    public static String orderStatusText(OrderEntity order) {
        int status = order.getOrderStatus();

        if (status == 101) {
            return "未付款";
        }

        if (status == 102) {
            return "已取消";
        }

        if (status == 103) {
            return "已取消(系统)";
        }

        if (status == 201) {
            return "已付款";
        }

        if (status == 202) {
            return "订单取消，退款中";
        }

        if (status == 203) {
            return "已退款";
        }

        if (status == 204) {
            return "已超时团购";
        }

        if (status == 301) {
            return "已发货";
        }

        if (status == 401) {
            return "已收货";
        }

        if (status == 402) {
            return "已收货(系统)";
        }

        throw new IllegalStateException("orderStatus不支持");
    }


    public static OrderHandleUtil build(OrderEntity order) {
        int status = order.getOrderStatus();
        OrderHandleUtil handle = new OrderHandleUtil();

        if (status == 101) {
            // 如果订单没有被取消，且没有支付，则可支付，可取消
            handle.setCancel(true);
            handle.setPay(true);
        } else if (status == 102 || status == 103) {
            // 如果订单已经取消或是已完成，则可删除
            handle.setDelete(true);
        } else if (status == 201) {
            // 如果订单已付款，没有发货，则可退款
            handle.setRefund(true);
        } else if (status == 202 || status == 204) {
            // 如果订单申请退款中，没有相关操作
        } else if (status == 203) {
            // 如果订单已经退款，则可删除
            handle.setDelete(true);
        } else if (status == 301) {
            // 如果订单已经发货，没有收货，则可收货操作,
            // 此时不能取消订单
            handle.setConfirm(true);
        } else if (status == 401 || status == 402) {
            // 如果订单已经支付，且已经收货，则可删除、去评论、申请售后和再次购买
            handle.setDelete(true);
            handle.setComment(true);
            handle.setRebuy(true);
            handle.setAftersale(true);
        } else {
            throw new IllegalStateException("status不支持");
        }

        return handle;
    }


    public static List<Integer> orderStatus(Integer showType) {
        // 全部订单
        if (showType == 0) {
            return null;
        }
        List<Integer> status = new ArrayList<>(2);
        if (showType.equals(1)) {
            // 待付款订单
            status.add(101);
        } else if (showType.equals(2)) {
            // 待发货订单
            status.add( 201);
        } else if (showType.equals(3)) {
            // 待收货订单
            status.add(301);
        } else if (showType.equals(4)) {
            // 待评价订单
            status.add(401);
            //系统超时自动取消，此时应该不支持评价
            //status.add((short)402);
        } else {
            return null;
        }
        return status;
    }

    /**
     * 创建订单状态
     */
    public static boolean isCreateStatus(OrderEntity order) {
        return OrderUtil.STATUS_CREATE == order.getOrderStatus().intValue();
    }

    /**
     *  101 订单生成，未支付；102，下单未支付用户取消；103
     */
    public static boolean hasPayed(OrderEntity order) {
        return OrderUtil.STATUS_CREATE != order.getOrderStatus().intValue()
                && OrderUtil.STATUS_CANCEL != order.getOrderStatus().intValue()
                && OrderUtil.STATUS_AUTO_CANCEL != order.getOrderStatus().intValue();
    }

    /**
     * 支付状态
     */
    public static boolean isPayStatus(OrderEntity order) {
        return OrderUtil.STATUS_PAY == order.getOrderStatus().intValue();
    }

    /**
     *商家发货，用户未确认；
     */
    public static boolean isShipStatus(OrderEntity order) {
        return OrderUtil.STATUS_SHIP == order.getOrderStatus().intValue();
    }

    /**
     *  用户确认收货
     */
    public static boolean isConfirmStatus(OrderEntity order) {
        return OrderUtil.STATUS_CONFIRM == order.getOrderStatus().intValue();
    }

    /**
     * 102，下单未支付用户取消
     */
    public static boolean isCancelStatus(OrderEntity order) {
        return OrderUtil.STATUS_CANCEL == order.getOrderStatus().intValue();
    }

    /**
     * 下单未支付用户取消
     */
    public static boolean isAutoCancelStatus(OrderEntity order) {
        return OrderUtil.STATUS_AUTO_CANCEL == order.getOrderStatus().intValue();
    }

    /**
     * 订单生产，已付款未发货，用户申请退款
     */
    public static boolean isRefundStatus(OrderEntity order) {
        return OrderUtil.STATUS_REFUND == order.getOrderStatus().intValue();
    }

    /**
     * 管理员执行退款操作，确认退款成功
     */
    public static boolean isRefundConfirmStatus(OrderEntity order) {
        return OrderUtil.STATUS_REFUND_CONFIRM == order.getOrderStatus().intValue();
    }

    /**
     * 用户没有确认收货，但是快递反馈已收货后，超过一定时间，系统自动确认收货，订单结束。
     */
    public static boolean isAutoConfirmStatus(OrderEntity order) {
        return OrderUtil.STATUS_AUTO_CONFIRM == order.getOrderStatus().intValue();
    }
}
