package com.example.wsreactive02;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.net.URI;
import java.time.Duration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageTest {

    private final WebSocketClient webSocketClient = new ReactorNettyWebSocketClient();
    @LocalServerPort
    private int port;

    @Test
    public void testJoinChatRoomAndSendMessage() {
        Mono<Void> result = webSocketClient.execute(
                        URI.create(String.format("ws://localhost:%d/message", port)),
                        session -> {
                            Flux<WebSocketMessage> messageFlux = Flux.just(
                                    session.textMessage("{\"command\":\"subscribe\",\"identifier\":{\"channel\":\"testChannel\",\"nickname\":\"testUser\"}}"),
                                    session.textMessage("{\"command\":\"message\",\"identifier\":{\"channel\":\"testChannel\",\"nickname\":\"testUser\"},\"message\":\"Test message\"}")
                            );

                            return session.send(messageFlux)
                                    .thenMany(session.receive().take(2).map(WebSocketMessage::getPayloadAsText))
                                    .doOnNext(message -> System.out.println("Received: " + message))
                                    .then();
                        })
                .timeout(Duration.ofSeconds(5));

        StepVerifier.create(result)
                .expectComplete()
                .verify(Duration.ofSeconds(10));
    }

    @Test
    public void testUserLeavesChatRoom() {
        Mono<Void> result = webSocketClient.execute(
                        URI.create(String.format("ws://localhost:%d/message", port)),
                        session -> {
                            Flux<WebSocketMessage> messageFlux = Flux.just(
                                    session.textMessage("{\"command\":\"subscribe\",\"identifier\":{\"channel\":\"testChannel\",\"nickname\":\"testUser\"}}")
                            );

                            return session.send(messageFlux)
                                    .thenMany(session.receive().take(1).map(WebSocketMessage::getPayloadAsText))
                                    .publishOn(Schedulers.boundedElastic())
                                    .doOnNext(message -> {
                                        System.out.println("Received: " + message);
                                        session.close().subscribe();
                                    })
                                    .thenMany(session.receive().take(1).map(WebSocketMessage::getPayloadAsText))
                                    .doOnNext(message -> System.out.println("Received: " + message))
                                    .then();
                        })
                .timeout(Duration.ofSeconds(5));

        StepVerifier.create(result)
                .expectComplete()
                .verify(Duration.ofSeconds(10));
    }

}
