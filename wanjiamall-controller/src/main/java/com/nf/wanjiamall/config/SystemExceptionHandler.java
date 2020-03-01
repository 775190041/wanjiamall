package com.nf.wanjiamall.config;


import com.nf.wanjiamall.vo.ResponseVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局错误处理
 * @author sam
 */
@RestControllerAdvice
public class SystemExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseVo updateDelete(RuntimeException r){
        return  ResponseVo.getFailed(r.getMessage());
    }

}
