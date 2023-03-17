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

	//https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#websocket-stomp-message-flow

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

		/**
		 * 위의 WebSocket 생성자에서 전달된 경로는 registerStompEndpoints() 메소드에서 등록한 WebSocket 엔드포인트와 동일해야 합니다.
		 *
		 * 그러나 위의 코드에서는 withSockJS() 메서드를 사용하여 SockJS를 지원하도록 WebSocket을 구성하고 있습니다. SockJS는 브라우저가 웹 소켓을 지원하지 않는 경우 대체 방법으로 HTTP Streaming, Long Polling 등을 사용하여 웹 소켓과 유사한 기능을 제공합니다.
		 *
		 * 따라서 위의 registerStompEndpoints() 메서드에서는 "/message" 경로를 등록하지만, SockJS를 사용하는 경우 /sockjs 엔드포인트도 함께 등록됩니다.
		 *
		 * 따라서 SockJS를 사용하는 경우 다음과 같이 WebSocket 경로 대신 SockJS 엔드포인트 경로를 사용해야합니다.
		 */
	}
}
