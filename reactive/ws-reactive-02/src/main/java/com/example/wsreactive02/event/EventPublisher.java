package com.example.wsreactive02.event;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Component
public class EventPublisher {
    private FluxSink<String> eventSink;

    public EventPublisher() {
        Flux<String> eventFlux = Flux.create(sink -> this.eventSink = sink);
    }

    public void publishEvent(String event) {
        eventSink.next(event);
    }
}
