package com.example.wsreactive02.event;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventWebSocketHandler implements WebSocketHandler {
    private final Flux<String> eventFlux;

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        // 클라이언트가 /topic/events 주제에 연결
        return session.receive()
                .map(WebSocketMessage::getPayloadAsText)
                .doOnNext(log::info)
//                .filter("/topic/events"::equals)
                .flatMap(topic -> {
                    // /topic/events 주제에 대해 구독을 생성하고 반환
                    Flux<String> messageFlux = eventFlux.map(evt -> "Event: " + evt);
                    return session.send(messageFlux.map(session::textMessage));
                })
                .then();
    }
}
