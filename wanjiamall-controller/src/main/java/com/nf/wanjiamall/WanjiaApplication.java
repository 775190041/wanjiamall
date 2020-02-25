package com.nf.wanjiamall;

import com.nf.wanjiamall.dao.IssueDao;
import com.nf.wanjiamall.entity.IssueEntity;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @author lzn
 */
@SpringBootApplication
@MapperScan("com.nf.wanjiamall.dao")
public class WanjiaApplication {

    public static void main(String[] args) {
         SpringApplication.run(WanjiaApplication.class, args);
    }
}
