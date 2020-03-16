package com.nf.wanjiamall.entity;

import lombok.Data;

@Data
public class AdminRoleRelationEntity {

    private Integer id;

    private Integer adminId;

    private Integer roleId;
}
