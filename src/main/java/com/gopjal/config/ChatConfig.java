package com.gopjal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.*;

@Configuration

@EnableWebSocketMessageBroker
public class ChatConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/websocketApp").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");
		 registry.enableSimpleBroker("/topic");
		/*
		 * registry.enableStompBrokerRelay("/topic").setRelayHost("localhost").
		 * setRelayPort(61613).setClientLogin("guest") .setClientPasscode("guest");
		 */

	}

}
