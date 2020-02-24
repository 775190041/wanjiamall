package com.nf.wanjiamall.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


public class ResponseVo<T> {
    @ApiModelProperty("状态码 0失败 1成功 2未登录 3没有权限")
    private Integer code;
    @ApiModelProperty("返回信息")
    private String msg;
    @ApiModelProperty("返回数据")
    private T data;
    public ResponseVo(Integer code, String msg) {
        this.code = code;        this.msg = msg;
    }
    public ResponseVo(Integer code, String msg, T data) {
        this.code = code;        this.msg = msg;        this.data = data;
    }

    public static <T> ResponseVo getSuccess(String msg) {
        return new ResponseVo(1, msg);
    }

    public static <T> ResponseVo getSuccess(String msg, T data) {
        return new ResponseVo(1, msg, data);
    }
    public static <T> ResponseVo getFailed(String msg) {
        return new ResponseVo(0, msg);
    }
    public static <T> ResponseVo getFailed(String msg, T data) {
        return new ResponseVo(0, msg, data);
    }
    public static <T> ResponseVo getNoLogin() {
        return new ResponseVo(2, "用户未登录，请重新登录");
    }
    public static <T> ResponseVo getNoAuthorization() {
        return new ResponseVo(3, "用户没有操作权限，请重新登录");
    }

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

     public void setMsg(String msg) {
        this.msg = msg;    }
        public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
