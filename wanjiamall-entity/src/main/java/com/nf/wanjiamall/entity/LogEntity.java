package com.nf.wanjiamall.entity;


import lombok.Data;

import java.util.Date;

@Data
public class LogEntity {

    private Integer id ;
    /** 管理员 */
    private String admin ;
    /** 管理员地址 */
    private String ip ;
    /** 操作动作 */
    private String action ;
    /** 操作状态;，0为成功，1为失败 */
    private Boolean status ;
    /** 补充信息 */
    private String comment ;
    /** 修改时间 */
    private Date updateTime ;
    /** 创建时间 */
    private Date addTime ;
    /** 逻辑删除 */
    private String delted ;

}
