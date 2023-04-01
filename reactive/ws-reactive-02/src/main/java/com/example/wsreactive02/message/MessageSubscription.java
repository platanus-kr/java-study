package com.example.wsreactive02.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@Slf4j
@Component
public class MessageSubscription {

    private final Map<String, Set<WebSocketSession>> subscriptions = new ConcurrentHashMap<>();
    private final Map<String, FluxSink<WebSocketMessage>> sinks = new ConcurrentHashMap<>();


    public void addSubscription(String identifier, String nickname, WebSocketSession session) {
        String uniqueKey = identifier + "-" + session.getId();
        subscriptions.computeIfAbsent(identifier, key -> new CopyOnWriteArraySet<>()).add(session);
        Flux<WebSocketMessage> flux = Flux.create(sink -> sinks.put(uniqueKey, sink));
        session.send(flux).subscribe();
        broadcastMessageToSubscribers(identifier, nickname, "subscribe success");
    }

    public void broadcastMessageToSubscribers(String identifier, String nickname, String message) {
        getSubscriptions(identifier).forEach(session -> {
            if (session.isOpen()) {
                String currentClientId = session.getId();
                String uniqueKey = identifier + "-" + currentClientId;
                FluxSink<WebSocketMessage> sink = sinks.get(uniqueKey);
                if (sink != null) {
                    sink.next(session.textMessage(message));
                }
            } else {
                removeSubscription(identifier, session);
            }
        });
    }


    public Set<WebSocketSession> getSubscriptions(String identifier) {
        return subscriptions.getOrDefault(identifier, Collections.emptySet());
    }


    public void removeSubscription(String identifier, WebSocketSession session) {
        if (subscriptions.containsKey(identifier)) {
            subscriptions.get(identifier).remove(session);
            if (subscriptions.get(identifier).isEmpty()) {
                subscriptions.remove(identifier);
                sinks.remove(identifier);
            }
        }
    }

}
