package com.nf.wanjiamall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author sam
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMsg {
    /**
     * 消息类型
     */
    private String type;
    /**
     * 消息来源
     */
    private String from;
    /**
     * 推送目标
     */
    private String to;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息时间
     */
    private Date date;

    private AdminEntity adminEntity;
}
