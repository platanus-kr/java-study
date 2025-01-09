package com.example.wsreactive02.config;


import com.example.wsreactive02.echo.EchoWebSocketHandler;
import com.example.wsreactive02.message.MessageWebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class CustomWebSocketConfig {

    private final MessageWebSocketHandler messageWebSocketHandler;

    @Bean
    public HandlerMapping handlerMapping() {
//        Map<String, CorsConfiguration> corsConfigurationMap = new HashMap<>();
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("http://localhost:8080");
//        corsConfigurationMap.put("/topic/events", corsConfiguration);

        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setUrlMap(
                Map.of("/ws/echo", new EchoWebSocketHandler(),
                        "/message/**", messageWebSocketHandler));
        mapping.setOrder(10);
//        mapping.setCorsConfigurations(corsConfigurationMap);
        return mapping;
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }
}
