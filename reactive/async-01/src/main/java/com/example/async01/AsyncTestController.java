package com.example.async01;

import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletRequest;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncTestController {

	@GetMapping("/result")
	@Async
	public CompletableFuture getResult(HttpServletRequest request) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		//Utils.sleepThisThread(500);
		return CompletableFuture.completedFuture("Out Now!");
	}
}
