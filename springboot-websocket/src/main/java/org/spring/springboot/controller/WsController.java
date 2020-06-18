package org.spring.springboot.controller;

import org.spring.springboot.config.WiselyMessage;
import org.spring.springboot.config.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author caigaolin
 * @version V1.0
 * @Package org.spring.springboot.controller
 * @date 2020/6/16 16:43
 * @Copyright © 2019-2020 河南拓普计算机网络工程有限公司
 */
@Controller
public class WsController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;//想浏览器发送消息

    @MessageMapping("/welcome")//1
    @SendTo("/topic/getResponse")//2
    public WiselyResponse say(WiselyMessage message) throws Exception {
        Thread.sleep(3000);
        return new WiselyResponse("welcome,"+message.getName()+"!");
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if (principal.equals("wyf")) {//发送人是wyf 则发送给wisely.发送人是wisely 则发送给wyf
            //参数1:接收消息的用户.参数2:浏览器订阅地址.参数3:消息本身
            messagingTemplate.convertAndSendToUser("wisely", "/queue/notifications", principal.getName() + "-send:" + msg);
        } else {
            messagingTemplate.convertAndSendToUser("wyf", "/queue/notifications", principal.getName() + "-send:" + msg);
        }
    }
}
