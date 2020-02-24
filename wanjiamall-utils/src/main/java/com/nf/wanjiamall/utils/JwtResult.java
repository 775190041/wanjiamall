package com.nf.wanjiamall.utils;

import io.jsonwebtoken.Claims;
import lombok.Data;

/**
 *验证token之后
 * @author Sam
 */
@Data
public class JwtResult {
    /**
     * 错误编码，JWTUtils中含义的常量
     */
    private String errCode;
    /**
     * 是否成功，
     */
    private Boolean success;

    /**
     * 验证过程中payload中的数据
     */
    private Claims claims;
}
