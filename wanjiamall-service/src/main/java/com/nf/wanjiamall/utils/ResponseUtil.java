package com.nf.wanjiamall.utils;


import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 响应操作结果
 * <pre>
 *  {
 *      code： 状态码，
 *      msg：返回信息，
 *      data：  响应数据
 *  }
 * </pre>
 *
 * <p>
 * 状态码：
 * <ul>
 * <li> 200，成功；
 * <ul>
 *
 * <ul>
 * <li> 4xx，前端错误，说明前端开发者需要重新了解后端接口使用规范：
 * <li> 401，参数错误，即前端没有传递后端需要的参数；
 * <li> 402，参数值错误，即前端传递的参数值不符合后端接收范围。
 * </ul>
 * <ul>
 * <li> 5xx，后端错误，除501外，说明后端开发者应该继续优化代码，尽量避免返回后端错误码：
 * <li> 501，验证失败，即后端要求用户登录；
 * <li> 502，系统内部错误，即没有合适命名的后端内部错误；
 * <li> 503，业务不支持，即后端虽然定义了接口，但是还没有实现功能；
 * <li> 504，更新数据失效，即后端采用了乐观锁更新，而并发更新时存在数据更新失效；
 * <li> 505，更新数据失败，即后端数据库更新失败,（修改更新失败）->正常情况应该更新成功
 * <li> 506，更新数据失败，即后端数据库更新失败,(添加更新失败)->正常情况应该更新成功。
 * <li> 507，更新数据失败，即后端数据库更新失败,(删除失败)->正常情况应该更新成功。
 * <li> 508，更新数据失败，即后端数据库更新失败,(退款失败)
 * </ul>
 * <ul>
 * <li> 601，该品牌已存在，
 * <li> 602，该品牌有商品绑定，无法删除该品牌
 *
 * </ul>
 */
public class ResponseUtil {
    /**
     *这个表示ok的方法表示成功的，
     * @return
     */
    public static Object ok() {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("code", 200);
        obj.put("msg", "成功");
        return obj;
    }

    public static Object ok(Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("code", 200);
        obj.put("msg", "成功");
        obj.put("data", data);
        return obj;
    }


    /**
     * 这个fail方法 表示失败的
     *
     * @return
     */
    public static Object fail() {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("code", -1);
        obj.put("msg", "错误");
        return obj;
    }

    public static Object fail(int code, String msg) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("code", code);
        obj.put("msg", msg);
        return obj;
    }

    /**
     *这个是查询把查询出来的数据放在这里就可以了
     * @param list
     * @return
     */
    public static Object okList(List list) {
        Map<String, Object> data = new HashMap<String, Object>();
        PageInfo pageInfo = new PageInfo(list,10);
        data.put("pageInfo", pageInfo);
        return ok(data);
    }


    public static Object badArgument() {
        return fail(401, "参数不对");
    }

    public static Object badArgumentValue() {
        return fail(402, "参数值不对");
    }

    public static Object unlogin() {
        return fail(501, "请登录");
    }

    public static Object serious() {
        return fail(502, "系统内部错误");
    }

    public static Object unsupport() {
        return fail(503, "业务不支持");
    }

    public static Object updatedDateExpired() {
        return fail(504, "更新数据已经失效");
    }

    public static Object updateDataFailed() {
        return fail(505, "修改失败");
    }

    public static Object insertDataFailed() {
        return fail(506, "添加失败");
    }

    public static Object deleteDataFailed() {
        return fail(507, "删除失败");
    }
    public static Object refundFailure(){
        return fail(508,"退款失败");
    }

    public static Object existBrandFailure(){
        return fail(601,"品牌已存在");
    }

    public static Object deleteBrandFailure(){
        return fail(602,"该品牌有商品绑定，无法删除该品牌");
    }
}
