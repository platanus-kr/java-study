package com.example.async01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Async01Application {

	public static void main(String[] args) {
		SpringApplication.run(Async01Application.class, args);
	}

}
