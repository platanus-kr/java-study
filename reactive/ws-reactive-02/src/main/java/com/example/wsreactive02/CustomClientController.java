package com.example.wsreactive02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Mono;

@Controller
public class CustomClientController {

	@GetMapping("/")
	public Mono<String> client() {
		return Mono.just("client");
	}
}
