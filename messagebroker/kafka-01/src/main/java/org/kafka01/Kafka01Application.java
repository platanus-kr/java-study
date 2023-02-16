package org.kafka01;

import org.kafka01.filter.KafkaFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Kafka01Application {

	public static void main(String[] args) {
		SpringApplication.run(Kafka01Application.class, args);
	}

	@Bean
	CommandLineRunner run(KafkaPubService kafkaPubService) {
		return args -> {
			System.out.println("Out now!");
			kafkaPubService.sendMessage("JUST IN TIME.");
		};
	}

}
