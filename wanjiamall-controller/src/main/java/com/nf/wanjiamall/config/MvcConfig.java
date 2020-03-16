package com.nf.wanjiamall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.Set;

/**
 * mvc全局配置
 * @author sam
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 跨域设置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE")
                .maxAge(3600);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new org.springframework.format.datetime.DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }
//    @Bean
//    public ConversionService getConversionService(DateConverterConfig dateConverter){
//        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
//
//        Set<Converter> converters = new HashSet<Converter>();
//
//        converters.add(new DateConverterConfig());
//
//        factoryBean.setConverters(converters);
//
//        return factoryBean.getObject();
//    }


}
