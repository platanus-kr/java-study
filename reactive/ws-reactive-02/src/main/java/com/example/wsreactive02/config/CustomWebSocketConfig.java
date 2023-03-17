package com.example.wsreactive02.config;


import com.example.wsreactive02.echo.EchoWebSocketHandler;
import com.example.wsreactive02.event.EventWebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class CustomWebSocketConfig {

    private final EventWebSocketHandler eventWebSocketHandler;

    @Bean
    public HandlerMapping handlerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setUrlMap(
                Map.of("/ws/echo", new EchoWebSocketHandler(),
                        "/events", eventWebSocketHandler));
        mapping.setOrder(10);
        return mapping;
    }
}
