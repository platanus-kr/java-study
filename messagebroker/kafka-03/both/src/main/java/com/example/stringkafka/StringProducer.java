package com.example.stringkafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StringProducer {

    public static final String TOPIC = "test03";

    private final KafkaTemplate<String, String> stringKafkaTemplate;

    public void sendMessage(String message) {
        this.stringKafkaTemplate.send(TOPIC, message);
    }
}
