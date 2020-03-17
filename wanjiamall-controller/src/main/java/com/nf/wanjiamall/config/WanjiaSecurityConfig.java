package com.nf.wanjiamall.config;


import com.nf.wanjiamall.entity.ResourceEntity;
import com.nf.wanjiamall.security.component.DynamicSecurityService;
import com.nf.wanjiamall.security.config.SecurityConfig;
import com.nf.wanjiamall.service.AdminService;
import com.nf.wanjiamall.service.ResourceService;
import com.nf.wanjiamall.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@EnableWebSecurity
//security 默认是禁用注解的,所以需要加把prePostEnabled 改为true
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WanjiaSecurityConfig extends SecurityConfig {


    @Autowired
    private AdminService adminService;
    @Autowired
    private ResourceService resourceService;

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        UserDetailsService userDetailsService= username -> adminService.loadUserByUsername(username);
        return userDetailsService;
    }

    //这个是登录成功后 获取所有的权限
    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                //管理员id
                AdminServiceImpl adminService = new AdminServiceImpl();
                Integer adminId = adminService.adminId;
                List<ResourceEntity> resourceList = resourceService.getResourceByAdminIdList(adminId);
                for (ResourceEntity resource : resourceList) {
                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
                }
                return map;
            }
        };
    }
}
