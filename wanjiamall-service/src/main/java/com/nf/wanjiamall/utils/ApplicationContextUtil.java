package com.nf.wanjiamall.utils;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@Data
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }

    public static  ApplicationContext getAppContext(){
        return context;
    }
}
