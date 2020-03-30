package com.nf.wanjiamall.controller;


import com.nf.wanjiamall.encoding.ChatMessageDecoder;
import com.nf.wanjiamall.encoding.ChatMessageEncoder;
import com.nf.wanjiamall.entity.AdminEntity;
import com.nf.wanjiamall.entity.ChatMsg;
import com.nf.wanjiamall.service.AdminService;
import com.nf.wanjiamall.service.impl.AdminServiceImpl;
import com.nf.wanjiamall.utils.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sam
 */
@Component
@Slf4j
@ServerEndpoint(value = "/chat/{username}",decoders = ChatMessageDecoder.class,encoders = ChatMessageEncoder.class)
public class WebsocketController  {


    /**
     * 线程安全的map集合，用来存放每个客户端对应的WebSocket对象。
     */
    private static ConcurrentHashMap<String, WebsocketController> webSocketMap = new ConcurrentHashMap();
    /**
     * 用户连接
     */
    private Session session;
    /**
     * 用户名
     */
    private String username;


    /**
     * 建立连接
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("username")String username,Session session) throws IOException {
        if(webSocketMap.get(username) != null){
            return;
        }
        this.session = session;
        this.username = username;
        //保存当前接入对象
        webSocketMap.put(username,this);
        log.info("新用户连入，username："+username+";  当前在线人数："+ getOnLineCount());
    }

    /**
     * 接收前端传来的消息
     * @param session
     * @param msg
     * @throws IOException
     */
    @OnMessage
    public void onMessage(Session session, ChatMsg msg) throws IOException {
        AdminEntity adminEntity = ApplicationContextUtil.getAppContext().getBean(AdminServiceImpl.class).getAdminByUsername(msg.getFrom());
        msg.setAdminEntity(adminEntity);
        if("GROUP".equals(msg.getType())) {
            sendInfo(msg);
        }
    }



    /**
     * 推送消息
     * @param message
     */
    public void sendMessage(ChatMsg message) {
        this.session.getAsyncRemote().sendObject(message);

    }

    /**
     * 群发自定义消息
     */
    public static void sendInfo(ChatMsg message) throws IOException {
        for (Map.Entry<String, WebsocketController> helloController : webSocketMap.entrySet()) {
            helloController.getValue().sendMessage(message);
        }
    }

    /**
     * 断开连接
     * @param session
     * @throws IOException
     */
    @OnClose
    public void onClose(Session session) throws IOException {
        session.close();//关闭当前连接
        webSocketMap.remove(username);
        log.info(username +"---连接断开，当前在线人数："+getOnLineCount());
    }

    /**
     * 连接异常
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session,Throwable throwable){
        log.info("session = " + session + ", throwable = " + throwable);
    }

    /**
     * 获得当前在线用户
     * @return
     */
    private Integer getOnLineCount(){
        return webSocketMap.entrySet().size();
    }

}
