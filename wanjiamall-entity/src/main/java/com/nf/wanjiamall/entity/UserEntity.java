package com.nf.wanjiamall.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 南八
 */
@Data
public class UserEntity {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户账号
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 生日
     */
    private Object birthday;
    /**
     * 最近一次登录时间
     */
    private Date lastLoginTime;
    /**
     * 最近一次登录IP地址
     */
    private String lastLoginIp;
    /**
     * 用户等级 0 普通用户，1 VIP用户，2 高级VIP用户
     */
    private Integer userLevel;
    /**
     * 用户账号名称
     */
    private String nickname;
    /**
     * 用户手机号码
     */
    private String mobile;
    /**
     * 用户头像图片
     */
    private String avatar;
    /**
     * 微信登录openid
     */
    private String weixinOpenid;
    /**
     * 微信登录会话key
     */
    private String sessionKey;
    /**
     * 用户状态 0 可用, 1 禁用, 2 注销
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date addTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 逻辑删除 删除时改变状态
     */
    private Integer deleted;
}
