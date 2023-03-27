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

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventWebSocketHandler implements WebSocketHandler {

    private final EventSubscription eventSubscription;

    @Override
    public Mono<Void> handle(WebSocketSession session) {


        return session.receive()
                .map(WebSocketMessage::getPayloadAsText)
                .flatMap(payload -> {
                    try {
                        JSONObject message = new JSONObject(payload);
                        String command = message.getString("command");
                        String identifier = message.getString("identifier");
                        JSONObject identifier1 = new JSONObject(identifier);
                        String channel = identifier1.getString("channel");

                        if ("subscribe".equals(command)) {
                            eventSubscription.addSubscription(channel);
                            log.info(eventSubscription.getSubscriptions().toString());
                            return Mono.empty();
                        }

                        if ("message".equals(command)) {
                            String data = message.getString("data");
                            JSONObject dataJson = new JSONObject(data);
                            String messageData = dataJson.getString("message");
                            log.info("message: " + messageData);
                            return Flux.just(messageData)
                                    .map(payload1 -> session.textMessage(payload1))
                                    .as(messages -> session.send(Mono.just(messages.blockFirst())));
                        }
                    } catch (JSONException e) {
                        log.error("Error parsing WebSocket message", e);
                    }
                    return Mono.error(new IllegalArgumentException("Invalid WebSocket message"));
                })
                .then()
                ;
    }

}
