package com.example.wsreactive02.event;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventWebSocketHandler implements WebSocketHandler {

    private final Set<String> eventSubscription;

//    public static Flux<String> eventFlux;

    @Override
    public Mono<Void> handle(WebSocketSession session) {


        return session.receive()
                .map(WebSocketMessage::getPayloadAsText)
                .flatMap(payload -> {  // JSON 형식으로 메시지를 파싱하여 명령과 식별자를 추출
                    try {
                        // JSON 형식으로 메시지를 파싱하여 명령과 식별자를 추출
                        JSONObject message = new JSONObject(payload);
                        String command = message.getString("command");
                        String identifier = message.getString("identifier");
                        JSONObject identifier1 = new JSONObject(identifier);
                        String channel =  identifier1.getString("channel");

                        // 명령이 'subscribe'이면 식별자를 Set에 추가
                        if ("subscribe".equals(command)) {
                            eventSubscription.add(channel);
                            log.info(eventSubscription.toString());
                            return Mono.empty();
                        }

                        if ("message".equals(command)) {
                            String data = message.getString("data");
                            JSONObject dataJson = new JSONObject(data);
                            String messageData = dataJson.getString("message");
                            log.info("message: " + messageData);
                            return Flux.just(messageData);
                        }
                    } catch (JSONException e) {
                        log.error("Error parsing WebSocket message", e);
                    }
                    return Mono.error(new IllegalArgumentException("Invalid WebSocket message"));
                })
//                .thenMany(eventFlux)
//                .map(evt -> "Event: " + evt)
                .filter(evt -> eventSubscription.stream().anyMatch(evt::contains))
                .map(session::textMessage)
                .as(session::send)
                .then();
    }

}
