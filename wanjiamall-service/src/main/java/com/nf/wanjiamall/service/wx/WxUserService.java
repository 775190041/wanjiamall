package com.nf.wanjiamall.service.wx;


import com.nf.wanjiamall.entity.UserEntity;

import java.io.IOException;

/**
 * @author lrc
 */
public interface WxUserService {

    Object getWxUserOpenid(String code) throws IOException;
}
