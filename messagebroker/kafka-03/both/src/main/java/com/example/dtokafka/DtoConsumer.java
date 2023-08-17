package com.example.dtokafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DtoConsumer {

    private static final String TOPIC = "test03-dto";

//    @KafkaListener(topics = TOPIC, groupId = "group_id")
//    public void consume(String message) throws JsonProcessingException {
//        log.info("Consume raw : " + message);
//        MessageDto dto = om.readValue(message, MessageDto.class);
//        log.info("Consume deserialize : " + dto.toString());
//    }

    @KafkaListener(topics = TOPIC, groupId = "group_id", containerFactory = "messageDtoListener")
    public void consume(MessageDto message) {
        log.info("Consume raw : " + message);
//        MessageDto dto = om.readValue(message, MessageDto.class);
//        log.info("Consume deserialize : " + dto.toString());
    }
}
