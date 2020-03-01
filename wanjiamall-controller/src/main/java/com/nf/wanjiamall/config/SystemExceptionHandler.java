package com.nf.wanjiamall.config;


import com.nf.wanjiamall.exception.AppException;
import com.nf.wanjiamall.vo.ResponseVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局错误处理
 * @author sam
 */
@RestControllerAdvice
public class SystemExceptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseVo updateDelete(AppException r){

        return  ResponseVo.getFailed(r.getMessage());
    }

}
