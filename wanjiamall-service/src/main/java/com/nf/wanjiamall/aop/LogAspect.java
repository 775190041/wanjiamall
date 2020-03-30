package com.nf.wanjiamall.aop;

import com.nf.wanjiamall.dao.LogDao;
import com.nf.wanjiamall.entity.AdminEntity;
import com.nf.wanjiamall.entity.LogEntity;
import com.nf.wanjiamall.vo.AdminUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Slf4j
@Order(Integer.MAX_VALUE)
public class LogAspect {

    @Autowired(required = false)
    private LogDao logDao;

    @Pointcut("execution(* com.nf.wanjiamall.service.impl.AdminServiceImpl.admin*(..))")
    public void admin(){

    }

    @Around(value = "admin()")
    public Object getAround(ProceedingJoinPoint joinPoint){
        Object result = null;
       RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
       HttpServletRequest request = null;
        if(requestAttributes!=null) {
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            request = servletRequestAttributes.getRequest();
        }
        LogEntity logEntity = new LogEntity();
        try {
            Long start = System.currentTimeMillis();
            result = joinPoint.proceed(joinPoint.getArgs());
            Long end = System.currentTimeMillis();
            log.info("查询时间：" + (end - start));
            logEntity.setAdmin(getUserInfo().getUsername());
            logEntity.setIp(request.getRemoteAddr());
            logEntity.setAction(request.getMethod().equals("POST")?"登录":"登出");
            logEntity.setStatus(true);
            logEntity.setComment("用时:"+(end-start)+"毫秒");
        } catch (Throwable throwable) {
            logEntity.setComment("登录失败");
            logEntity.setStatus(false);
            throw new RuntimeException(throwable);
        }finally {
            logDao.logInsert(logEntity);
        }
        return result;
    }
    private AdminUserDetails getUserInfo(){
        AdminUserDetails adminEntity = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return adminEntity;
    }

}
