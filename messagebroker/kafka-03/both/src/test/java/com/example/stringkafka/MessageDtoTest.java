package com.example.stringkafka;


import com.example.dtokafka.MessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class MessageDtoTest {
    private static final ObjectMapper om = new ObjectMapper().registerModule(new JavaTimeModule());


    @Test
    void serialize() throws JsonProcessingException {
        MessageDto dto = MessageDto.builder()
                .message("메시지").
                roomId("1111-2222-3333")
                .sendAt(LocalDateTime.now())
                .type("TEXT")
                .uid("aaaa-bbbb-dddd")
                .build();
        String s = om.writeValueAsString(dto);

        System.out.println(s);
    }

    @Test
    void deserializeString() throws JsonProcessingException {
        MessageDto dto = MessageDto.builder()
                .message("메시지").
                roomId("1111-2222-3333")
                .sendAt(LocalDateTime.now())
                .type("TEXT")
                .uid("aaaa-bbbb-dddd")
                .build();
        String s = om.writeValueAsString(dto);

        MessageDto messageDto = om.readValue(s, MessageDto.class);
        System.out.println(messageDto);

    }
}
