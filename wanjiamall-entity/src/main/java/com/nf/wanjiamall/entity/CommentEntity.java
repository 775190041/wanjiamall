package com.nf.wanjiamall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品评论表
 */
@Data
public class CommentEntity {
    /**
     * 评论id
     */
    private Integer id;

    /**
     *如果type=0，则是商品评论；如果是type=1，则是专题评论。
     */
    private Integer valueId;

    /**
     *评论类型，如果type=0，则是商品评论；如果是type=1，则是专题评论
     */
    private Integer type;

    /**
     * 评论内容
     */
    private String content;

    /**
     *管理员回复内容
     */
    private String adminContent;

    /**
     *用户表的用户ID
     */
    private Integer userId;

    /**
     *是否含有图片
     */
     private Integer hasPicturn;

    /**
     *图片地址列表，采用JSON数组格式
     */
    private String picUrls;

    /**
     * 评分， 1-5
     */
    private Integer star;

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
    private Integer delted;
}
