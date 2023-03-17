package com.example.wsreactive02.echo;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;

import reactor.core.publisher.Mono;

@Slf4j
public class EchoWebSocketHandler implements WebSocketHandler {
	@Override
	public Mono<Void> handle(WebSocketSession session) {
		return session // WebSocketSession
				.receive()// DataBuffer wrapper
				.map(WebSocketMessage::getPayloadAsText)// Byte payload to text
				.doOnNext(message -> {
					log.info("Recieved message: " + message);
				})
				.map(tm -> "Echo: " + tm)
				.map(session::textMessage)
				.as(session::send); // Send to client
	}
}
