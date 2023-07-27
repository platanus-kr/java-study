package com.example.stringkafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StringConsumer {

    public static final String TOPIC = "test03";

    @KafkaListener(topics = TOPIC, groupId = "group_id", containerFactory = "stringListener")
    public void consume(String message) {
        log.info("Consume 메시지 : " + message);
    }
}
