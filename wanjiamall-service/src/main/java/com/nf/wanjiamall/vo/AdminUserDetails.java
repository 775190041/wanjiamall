package com.nf.wanjiamall.vo;

import com.nf.wanjiamall.entity.AdminEntity;
import com.nf.wanjiamall.entity.ResourceEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 黑夜
 * 这个类主要是security 登录成功后，需要用户访问路径
 */
public class AdminUserDetails implements UserDetails {
    private AdminEntity adminEntity;
    private List<ResourceEntity> resourceEntities;

    private Integer adminId;

    public AdminUserDetails(AdminEntity adminEntity,List<ResourceEntity> resourceEntities) {
        this.adminEntity = adminEntity;
        this.resourceEntities = resourceEntities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的角色
        return resourceEntities.stream()
                .map(role ->new SimpleGrantedAuthority(role.getUrl()))
                .collect(Collectors.toList());
    }
    //把查询的密码放入userDetails中
    @Override
    public String getPassword() {
        return adminEntity.getPassword();
    }
    //把查询的用户账号放入userDetails中
    @Override
    public String getUsername() {
        return adminEntity.getUsername();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    //这个是判断该用户的状态
    @Override
    public boolean isEnabled() {
        return adminEntity.getDeletedState();
    }
}
