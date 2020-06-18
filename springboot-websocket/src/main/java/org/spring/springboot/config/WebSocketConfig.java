package org.spring.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author caigaolin
 * @version V1.0
 * @Package org.spring.springboot.config
 * @date 2020/6/16 16:19
 * @Copyright © 2019-2020 河南拓普计算机网络工程有限公司
 */
@Configuration
@EnableWebSocketMessageBroker//1
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {//2
        registry.addEndpoint("/endpointWisely").withSockJS();//3
        registry.addEndpoint("/endpointChat").withSockJS();//3.1
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {//4
        registry.enableSimpleBroker("/topic");
        registry.enableSimpleBroker("queue","topic");
//        super.configureMessageBroker(registry);//5
    }
}
