package com.nf.wanjiamall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lrc
 */
@SpringBootApplication(scanBasePackages="com.nf.wanjiamall.controller")
@MapperScan(basePackages = {"com.nf.wanjiamall.dao"})
@ComponentScan(basePackages = {"com.nf.*"})
public class WanjiaApplication {

    public static void main(String[] args) {
       SpringApplication.run(WanjiaApplication.class, args);
    }
}
