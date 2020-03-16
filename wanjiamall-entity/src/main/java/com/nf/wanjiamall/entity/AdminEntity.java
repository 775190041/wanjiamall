package com.nf.wanjiamall.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AdminEntity {


    /**
     * 该管理员拥有几个角色
     */
    private List<Integer> roleId;

    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 管理员密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像图片
     */
    private String avatar;



    /**
     * 最近登录时间
     */
    private Date loginTime;
    /**
     * 正常0，停用1
     */
    private Integer deletedState;
    /**
     * 创建时间
     */
    private Date addTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 逻辑删除
     */
    private String delted;

}
