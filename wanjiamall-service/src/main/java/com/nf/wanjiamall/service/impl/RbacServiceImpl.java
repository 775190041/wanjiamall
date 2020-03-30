package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.entity.ResourceEntity;
import com.nf.wanjiamall.service.RbacService;
import com.nf.wanjiamall.vo.AdminUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 权限判断实现
 * @author Sam
 */
@Service("rbacService")
@Slf4j
public class RbacServiceImpl implements RbacService {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        boolean hasPermission = false;
        if(principal instanceof AdminUserDetails){
            Collection<GrantedAuthority> authorityList = (Collection<GrantedAuthority>) ((AdminUserDetails) principal).getAuthorities();
            for (GrantedAuthority grantedAuthority : authorityList) {
                if (antPathMatcher.match(grantedAuthority.getAuthority(), request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }


}
