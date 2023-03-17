package com.example.wsreactive02.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Configuration

public class EventFluxConfig {
    @Bean
    public Flux<String> eventFlux() {
        return Flux.<String>create(sink -> {
            //
        }).share();
    }
}
