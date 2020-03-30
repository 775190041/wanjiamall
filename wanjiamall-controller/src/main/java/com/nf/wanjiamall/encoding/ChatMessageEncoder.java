package com.nf.wanjiamall.encoding;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.wanjiamall.entity.ChatMsg;
import com.nf.wanjiamall.utils.JsonUtils;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * @author cj
 * @date 2018/11/16
 */
public class ChatMessageEncoder implements Encoder.Text<ChatMsg> {
    @Override
    public String encode(ChatMsg object) throws EncodeException {
        return JsonUtils.getJsonString(object);

    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
