package com.example.dtokafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DtoProducer {

    private static final String TOPIC = "test03-dto";

    private final KafkaTemplate<String, MessageDto> messageDtoKafkaTemplate;


    public void sendMessage(MessageDto dto) {
        this.messageDtoKafkaTemplate.send(TOPIC, dto);
    }
}
