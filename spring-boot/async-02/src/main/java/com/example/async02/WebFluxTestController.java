package com.example.async02;

import java.time.Duration;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class WebFluxTestController {

	@GetMapping("/result")
	public Mono<String> getResult() {
		return Mono.defer(() -> Mono.just("OutNow!"))
				.delaySubscription(Duration.ofMillis(500));
	}
}
