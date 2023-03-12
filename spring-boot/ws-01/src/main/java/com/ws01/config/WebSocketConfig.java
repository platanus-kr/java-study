package com.ws01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	// AbstractWebSocketMessageBrokerConfigurer 는 Deprecated.

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// 먼저 메모리 내 메시지 브로커가 "/topic" 접두사가 붙은 대상에서 클라이언트로 메시지를 다시 전달할 수 있습니다.
		config.enableSimpleBroker("/topic");
		// @MessageMapping 을 통해 애플리케이션 주석이 달린 메서드를 대상으로 하는 필터링 대상에 "/app" 접두사를 지정하여 간단한 구성을 완료합니다 .
		// 접두사 "/app"가 붙은 이 끝점은 ChatController.send() 메서드가 처리하도록 매핑되는 끝점입니다.
		config.setApplicationDestinationPrefixes("/app");
		//WebSocketMessageBrokerConfigurer.super.configureMessageBroker(config);
	}
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// "/chat" 엔드포인트를 등록하여 Spring의 STOMP 지원을 활성화합니다. 탄력성을 위해 SockJS 없이 작동하는 끝점도 여기에 추가하고 있음을 명심하십시오.
		registry.addEndpoint("/chat");
		// WebSocket을 사용할 수 없는 경우 대체 메시징 옵션을 사용할 수 있도록 SockJS 폴백 옵션 을 활성화합니다 .
		registry.addEndpoint("/chat").withSockJS();
		//WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
	}
}
