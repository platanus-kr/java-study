package com.example.wsreactive02.event;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class EventConsumer {

    public EventConsumer(Flux<String> eventFlux) {
        eventFlux.filter(event -> "/topic/events".equals(event))
                .subscribe(event -> {
                });
    }
}
