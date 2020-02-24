package com.nf.wanjiamall.utils.aliyun;

import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * 生成token令牌，
 * 验证token令牌
 * @author Sam
 */
public class JwtUtils {
    //服务器的key,用于做加解密的数据，如果可以使用客户端生成的key的话，当前可以不使用
    private static final String JWT_SELECT = "jwt_secert";
    //token过期
    public static final String JWT_ERRCOOE_EXPIRE = "1005";
    //验证不通过
    public static final String JWT_ERRCOOE_FAIL = "1006";

    /**
     * 生成密匙
     * @return
     */
    public static SecretKey generalKey(){
        byte[] encodedKey = JWT_SELECT.getBytes();
        SecretKey key = new SecretKeySpec(encodedKey,0,encodedKey.length,"AES");
        return key;
    }

    /**
     * 签发jwt，创建token的方法
     * @param id 比如uuid或者主键 jwt的唯一身份标识，主要用来作为一次性token,
     * @param iss jwt的签发者
     * @param subject jwt所面向的对象，记录的公开信息
     * @param ttlMillis 有效期，单位毫秒
     * @return
     */
    public static String createJWT(String id,String iss,String subject,long ttlMillis){
        //加密算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //当前时间
        long nowMillis = System.currentTimeMillis();
        //当前时间的日期对象
        Date now = new Date(nowMillis);
        //创建jwt的构建起，就是使用特定的加密算法，生成token的工具
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuer(iss)
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(signatureAlgorithm,secretKey); //设定密匙和算法
        if (ttlMillis>=0){
            long expMills = nowMillis + ttlMillis;
            Date expDate = new Date(expMills);
            builder.setExpiration(expDate);
        }
        return builder.compact();
    }

    /**
     * 该方法返回的时校验之后的token
     * @param jwtStr
     * @return
     */
    public static JwtResult validateJWT(String jwtStr){
        JwtResult checkResult = new JwtResult();
        Claims claims = null;
        try {

            claims = pareseJWT(jwtStr);
            checkResult.setSuccess(true);
            checkResult.setClaims(claims);
        }catch (ExpiredJwtException e){ //超时
            checkResult.setSuccess(false);
            checkResult.setErrCode(JWT_ERRCOOE_EXPIRE);
        }catch (SignatureException e){ //校验失败
            checkResult.setSuccess(false);
            checkResult.setErrCode(JWT_ERRCOOE_FAIL);
        }catch (Exception e){
            checkResult.setSuccess(false);
            checkResult.setErrCode(JWT_ERRCOOE_FAIL);
        }
        return checkResult;
    }

    /**
     * 解析字符串
     * @param jwt 就是服务器为客户端生成的签名数据，就是token
     * @return
     * @throws Exception
     */
    public static Claims pareseJWT(String jwt) throws Exception{
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody(); //获取token中的payload的信息，就是Claims
    }

    /**
     * 生成subject信息
     * @param subObj
     * @return
     */
    public static String generalSubject(Object subObj){
       return  JsonUtils.getJsonString(subObj);
    }
    public static void main(String[] args) throws Exception {
        String s = createJWT("1","12","234",1*60*10000);
        System.out.println(s);
       JwtResult jwtResult = JwtUtils.validateJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwiaXNzIjoiMTIiLCJzdWIiOiIyMzQiLCJpYXQiOjE1NzYzOTgwMjIsImV4cCI6MTU3NjM5ODYyMn0.QYJy-d9IPAi-QD8XvRA1UKIj4b7kjtMvqpPubkq-t48");
        System.out.println(jwtResult);
    }
}
