package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.service.board.BoardService;
import com.example.demo.service.board.JongpakBoardService;
import com.example.demo.service.board.MaskingBoardService;
import com.example.demo.service.database.DatabaseService;
import com.example.demo.service.database.InMemoryDatabaseService;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	
	@Bean
	public DatabaseService databaseService() {
		return new InMemoryDatabaseService();
	}
	
	@Bean
	public BoardService boardService() {
		return new MaskingBoardService();
	}

}
