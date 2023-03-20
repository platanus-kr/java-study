package com.example.reactor01;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class RequestTest {
	@Test
	void test(){
		
		//Flux<String> flux = Flux.interval(Duration.ofMillis(1000)).take(10).;
		Flux<String> flux = Flux.just("a", "b", "c", "d", "e", "f").log()
				.window(2)
				.blockLast();
		
		StepVerifier.create(flux).thenRequest(6);
	}

}
