package com.example.dtokafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    /**
     * 뭐가 들어가야 할까
     * 발신자 ID
     * 메시지
     * 타입
     * 채팅방 ID
     * 타임스탬프
     */

    @JsonProperty
    private String uid;

    @JsonProperty
    private String message;

    @JsonProperty
    private String type;

    @JsonProperty("room_id")
    private String roomId;

    @JsonProperty("send_at")
    private LocalDateTime sendAt;
}
