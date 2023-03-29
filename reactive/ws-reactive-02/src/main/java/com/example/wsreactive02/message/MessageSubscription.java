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
//    private final Map<String, FluxSink<String>> sinks = new ConcurrentHashMap<>();
    private final Map<String, FluxSink<WebSocketMessage>> sinks = new ConcurrentHashMap<>();


    public void addSubscription(String identifier, String clientId, WebSocketSession session) {
        String uniqueKey = identifier + "-" + clientId;
        subscriptions.computeIfAbsent(identifier, key -> new CopyOnWriteArraySet<>()).add(session);
//        log.info(subscriptions.get(uniqueKey).toString());
        Flux<WebSocketMessage> flux = Flux.create(sink -> sinks.put(uniqueKey, sink));
//        Flux<String> flux = Flux.create(sink -> sinks.put(uniqueKey, sink));
        session.send(flux).subscribe();
//        session.send(flux.map(session::textMessage)).subscribe();
        broadcastMessageToSubscribers(identifier, clientId, "subscribe success");
    }

    public void broadcastMessageToSubscribers(String identifier, String clientId, String message) {
        String uniqueKey = identifier + "-" + clientId;
        FluxSink<WebSocketMessage> sink = sinks.get(uniqueKey);
        if (sink != null) {
            getSubscriptions(identifier).forEach(session -> {
                if (session.isOpen()) {
                    sink.next(session.textMessage(message));
                } else {
                    removeSubscription(uniqueKey, session);
                }
            });
        }
//        getSubscriptions(uniqueKey).forEach(session -> {
//            if (session.isOpen()) {
//                FluxSink<String> sink = sinks.get(uniqueKey);
//                if (sink != null) {
//                    sink.next(message);
//                }
//            } else {
//                removeSubscription(identifier + "-" + clientId, session);
//            }
//        });
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

    public Set<WebSocketSession> getSubscriptions(String identifier) {
        return subscriptions.getOrDefault(identifier, Collections.emptySet());
    }

//    public void removeSession(WebSocketSession session) {
//        subscriptions.forEach((identifier, sessions) -> {
//            sessions.remove(session);
//            if (sessions.isEmpty()) {
//                sinks.remove(identifier);
//            }
//        });
//    }

//    public void broadcastMessageToSubscribers(String identifier, String message) {
//        getSubscriptions(identifier).forEach(session -> {
//            if (session.isOpen()) {
//                session.send(Mono.just(session.textMessage(message)).doOnError(e -> {
//                    log.error("Error sending message to WebSocket session", e);
//                }).onErrorResume(e -> Mono.empty())).subscribe();
//            } else {
//                removeSubscription(identifier, session);
//            }
//        });
//    }


}
