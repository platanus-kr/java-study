package com.example.wsreactive02.message;


import com.example.wsreactive02.message.dto.ChannelSubscribeDto;
import com.example.wsreactive02.message.dto.IdentifierDto;
import com.example.wsreactive02.message.dto.MessageRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageWebSocketHandler implements WebSocketHandler {

    private final SubscriptionManager subscriptionManager;
    private final MessageBroadcaster messageBroadcaster;
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    /**
     * <h4>메시지 처리를 위한 핸들러</h4>
     * HandlerMapping 으로 부터 전달된 세션을 처리한다. <br />
     * 크게 메시지 처리 부분과 연결 해제시 구독 해제 부분으로 나뉜다.
     *
     * @param session 웹소켓 세션
     * @return 메시지 처리 후 Mono<Void>
     */
    @Override
    public Mono<Void> handle(WebSocketSession session) {
        AtomicReference<ChannelSubscribeDto> channelSub = new AtomicReference<>();
        return session.receive()
                .map(WebSocketMessage::getPayloadAsText)
                .publishOn(Schedulers.boundedElastic())
                .flatMap(payload -> handleMessage(payload, session, channelSub))
                .doFinally(signalType -> handleDisconnection(signalType, channelSub, session))
                .then();
    }

    /**
     * <h4>메시지 처리</h4>
     * Stub 내 command로 분기하여 메시지를 처리한다. <br />
     * subscribe 는 {@link SubscriptionManager} 에 구독을 추가하고, <br />
     * message 는 {@link MessageBroadcaster} 로 메시지를 전달한다.
     *
     * @param payload    메시지 Payload
     * @param session    웹소켓 세션
     * @param channelSub 구독 정보
     * @return
     */
    private Mono<Void> handleMessage(String payload,
                                     WebSocketSession session,
                                     AtomicReference<ChannelSubscribeDto> channelSub) {
        try {
            MessageRequestDto messageRequestDto = objectMapper.readValue(payload, MessageRequestDto.class);
            String command = messageRequestDto.getCommand();
            IdentifierDto identifier = messageRequestDto.getIdentifier();
            ChannelSubscribeDto stub = ChannelSubscribeDto.builder()
                    .channel(identifier.getChannel())
                    .nickname(identifier.getNickname())
                    .build();
            channelSub.set(stub);

            if ("subscribe".equals(command)) {
                return processSubscribeCommand(stub, session);
            } else if ("message".equals(command)) {
                return processMessageCommand(stub, messageRequestDto.getMessage());
            }
        } catch (IOException e) {
            log.error("Error parsing WebSocket message", e);
        }
        return Mono.error(new IllegalArgumentException("Invalid WebSocket message"));
    }

    /**
     * <h4>구독 처리</h4>
     *
     * @param stub    구독 정보
     * @param session 세션
     * @return 구독 추가 후 Mono.empty()
     */
    private Mono<Void> processSubscribeCommand(ChannelSubscribeDto stub, WebSocketSession session) {
        subscriptionManager.addSubscription(stub.getChannel(), session);
        log.info(stub.getChannel() + " 채널에 " + stub.getNickname() + " 님이 입장하셨습니다.");
        messageBroadcaster.broadcastMessageToSubscribers(stub.getChannel(), "SYSTEM", stub.getNickname() + "님이 채팅방에 입장 했습니다.");
        return Mono.empty();
    }

    /**
     * <h4>메시지 처리</h4>
     *
     * @param stub        구독 정보
     * @param messageText 메시지
     * @return 메시지 브로드캐스트 후 Mono.empty()
     */
    private Mono<Void> processMessageCommand(ChannelSubscribeDto stub, String messageText) {
        String message;
        try {
            message = objectMapper.writeValueAsString(messageText);
        } catch (JsonProcessingException e) {
            log.error("Error serializing message to JSON", e);
            return Mono.empty();
        }
        // 채팅방에 있는 모든 사용자에게 메시지를 전달합니다.
        messageBroadcaster.broadcastMessageToSubscribers(stub.getChannel(), stub.getNickname(), message);
        return Mono.empty();
    }

    /**
     * <h4>연결 해제 처리</h4>
     * 웹소켓 연결이 해제 되었을때 구독을 해지하는 이유는 크게 3가지로 보인다. <br />
     * <ul>
     *     <li>리소스 낭비 방지 : 연결을 해제 함으로써 메모리 사용량 줄이기 (이걸로..?)</li>
     *     <li>연결되지 않은 소켓에 전송 방지 : 연결이 종료된 소켓에 메시지 전송을 시도하면 에러 발생. 해제를 통해 이를 1차적으로 방지한다.</li>
     *     <li>실시간 구독자 정보 유지 : 사용자들이 채팅방에 참여하거나 떠나는것을 실시간으로 반영하고 구독자 수를 정확하게 표시한다.</li>
     * </ul>
     *
     * @param signalType 리엑티브 스트림의 시그널 타입
     * @param channelSub 구독 정보
     * @param session    웹소켓 세션
     */
    private void handleDisconnection(SignalType signalType,
                                     AtomicReference<ChannelSubscribeDto> channelSub,
                                     WebSocketSession session) {
        if (SignalType.ON_COMPLETE.equals(signalType) || SignalType.ON_ERROR.equals(signalType)) {
            ChannelSubscribeDto stub = channelSub.get();
            messageBroadcaster.broadcastMessageToSubscribers(stub.getChannel(),
                    "SYSTEM", stub.getNickname() + "가 퇴장합니다.");
            subscriptionManager.removeSubscription(stub.getChannel(), session);
        }
    }
}
