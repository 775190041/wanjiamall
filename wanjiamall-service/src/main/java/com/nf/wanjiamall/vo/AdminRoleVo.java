package com.nf.wanjiamall.vo;

import com.nf.wanjiamall.entity.AdminEntity;
import com.nf.wanjiamall.entity.RoleEntity;
import lombok.Data;

import java.util.List;

@Data
public class AdminRoleVo {
    List<RoleEntity> roleEntities;
    AdminEntity adminEntity;

    public AdminRoleVo(List<RoleEntity> roleEntities, AdminEntity adminEntity) {
        this.roleEntities = roleEntities;
        this.adminEntity = adminEntity;
    }
}
