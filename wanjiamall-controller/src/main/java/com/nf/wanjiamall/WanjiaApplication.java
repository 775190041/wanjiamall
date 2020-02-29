package com.nf.wanjiamall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author lzn
 */
@SpringBootApplication
@MapperScan("com.nf.wanjiamall.dao")
public class WanjiaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(WanjiaApplication.class, args);

    }
}
