package com.example.wsreactive02.message;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageWebSocketHandler implements WebSocketHandler {

    private final MessageSubscription messageSubscription;

    @Override
    public Mono<Void> handle(WebSocketSession session) {

        /**
         * WebSockerHandler 코드에서 빠진 부분은 subscribe 커맨드를 처리하는 부분에서 반환되는 Mono입니다.
         * subscribe 커맨드를 처리하는 부분에서 Mono.empty()를 반환하고 있습니다.
         * 그러나 subscribe 커맨드는 채팅방에 입장하기 위해 필요한 커맨드입니다.
         * 채팅방에 입장하기 위해서는 해당 채널을 구독해야 합니다.
         * 따라서 이 부분을 고치기 위해서는, messageSubscription.addSubscription(channel) 다음에
         * Mono.just(session).flatMap(WebSocketSession::send)를 추가하여,
         * WebSocket 세션에 입장 성공 여부를 클라이언트에게 전달해줘야 합니다.
         */
        AtomicReference<String> channelSub = new AtomicReference<>();
        return session.receive()
                .map(WebSocketMessage::getPayloadAsText)
                .publishOn(Schedulers.boundedElastic())
                .flatMap(payload -> {
                    try {
                        JSONObject message = new JSONObject(payload);
                        String command = message.getString("command");
                        JSONObject identifier = message.getJSONObject("identifier");
                        String channel = identifier.getString("channel");
                        String clientId = identifier.getString("clientId");
                        channelSub.set(channel);
                        if ("subscribe".equals(command)) {
                            messageSubscription.addSubscription(channel, clientId, session);
//                            Mono.just(session).flatMap(s -> s.send(Mono.just(s.textMessage("subscribe success"))));
//                            messageSubscription.broadcastMessageToSubscribers(channel, "subscribe success");
                            return Mono.empty();
                        }

                        if ("message".equals(command)) {
                            String data = message.getString("data");
                            JSONObject dataJson = new JSONObject(data);
                            String messageData = dataJson.getString("message");
                            // 채팅방에 있는 모든 사용자에게 메시지를 전달합니다.
                            messageSubscription.broadcastMessageToSubscribers(channel, clientId, messageData);
                            return Mono.empty();
                        }
                    } catch (JSONException e) {
                        log.error("Error parsing WebSocket message", e);
                    }
                    return Mono.error(new IllegalArgumentException("Invalid WebSocket message"));
                })
                .doFinally(signalType -> {
                    // 연결 종료 시, 구독 취소 처리를 합니다.
                    if (SignalType.ON_COMPLETE.equals(signalType) || SignalType.ON_ERROR.equals(signalType)) {
//                        messageSubscription.removeSession(session);
                        messageSubscription.removeSubscription(channelSub.get(), session);
                    }
                })
                .then();
    }

}
