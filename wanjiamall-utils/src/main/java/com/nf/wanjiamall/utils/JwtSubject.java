package com.nf.wanjiamall.utils;


import lombok.Builder;
import lombok.Data;

/**
 * 作为Subject数据使用，也就是payload中保存的 claims
 * subject的负载payload
 * @author Sam
 */
@Data
@Builder
public class JwtSubject {
    private String username;

    public JwtSubject() {

    }

    public JwtSubject(String username) {
        this.username = username;
    }
}
