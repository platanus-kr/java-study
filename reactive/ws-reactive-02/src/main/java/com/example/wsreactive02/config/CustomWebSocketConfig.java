package com.example.wsreactive02.config;


import com.example.wsreactive02.echo.EchoWebSocketHandler;
import com.example.wsreactive02.event.EventWebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class CustomWebSocketConfig {

    private final Flux<String> eventFlux;
//    private final EventWebSocketHandler eventWebSocketHandler;

    @Bean
    public HandlerMapping handlerMapping() {
        Map<String, CorsConfiguration> corsConfigurationMap = new HashMap<>();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://localhost:8080");
        corsConfigurationMap.put("/topic/events", corsConfiguration);

        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setUrlMap(
                Map.of("/ws/echo", new EchoWebSocketHandler(),
                        "/events", new EventWebSocketHandler(eventFlux)));
        mapping.setOrder(10);
        mapping.setCorsConfigurations(corsConfigurationMap);
        return mapping;
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }
}
