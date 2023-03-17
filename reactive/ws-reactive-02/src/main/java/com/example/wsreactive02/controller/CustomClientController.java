package com.example.wsreactive02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Mono;

@Controller
public class CustomClientController {

	@GetMapping("/")
	public Mono<String> front() {
		return Mono.just("front");
	}
	@GetMapping("/echo")
	public Mono<String> echo() {
		return Mono.just("echo");
	}

	@GetMapping("/event")
	public Mono<String> event() {
		return Mono.just("event");
	}
}
