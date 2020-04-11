package com.nf.wanjiamall.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 订单号生成工具类
 */
public class OrderNumberUtil {

    // TODO 这里应该产生一个唯一的订单，但是实际上这里仍然存在两个订单相同的可能性
    public static String generateOrderNo() {
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        StringBuilder stringBuilder = new StringBuilder(format.format(new Date()));
        for (int i = 0; i < 1; i++) {
            stringBuilder.append(new Random().nextInt(2));
        }
        return stringBuilder.toString();
    }
}
