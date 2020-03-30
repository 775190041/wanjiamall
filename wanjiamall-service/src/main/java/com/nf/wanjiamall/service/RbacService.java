package com.nf.wanjiamall.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * 主要作用是用于权限表达式的判断
 *
 * @author Sam
 */
public interface RbacService {
    /**
     *将请求地址和用户的相关权限进行比对
     * @param request
     * @param authentication
     * @return
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
