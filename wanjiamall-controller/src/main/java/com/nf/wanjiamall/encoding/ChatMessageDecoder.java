package com.nf.wanjiamall.encoding;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.wanjiamall.entity.ChatMsg;
import com.nf.wanjiamall.utils.JacksonUtil;
import com.nf.wanjiamall.utils.JsonUtils;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;

/**
 * @author cj
 * @date 2018/11/16
 */
public class ChatMessageDecoder implements Decoder.Text<ChatMsg> {
    @Override
    public ChatMsg decode(String s) throws DecodeException {
        return JsonUtils.readValue(s,ChatMsg.class);
    }

    /**
     * 返回true才会真正进入到decode方法进行解码操作
     * @param s
     * @return
     */
    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
