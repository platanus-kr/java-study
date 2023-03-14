package com.example.wsreactive02;


import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;

@Configuration
public class CustomWebSocketConfig {
	@Bean
	public HandlerMapping handlerMapping() {
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		mapping.setUrlMap(Collections.singletonMap("/ws/echo", new CustomWebSocketHandler()));
		mapping.setOrder(10);
		return mapping;
	}
}
