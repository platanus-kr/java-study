package com.example.securitytest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Security2Application {

	public static void main(String[] args) {
		SpringApplication.run(Security2Application.class, args);
	}

}
