package com.example.demo.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.database.DatabaseService;

public class JongpakBoardService implements BoardService {
	
	@Autowired
	private DatabaseService databaseService;
	
	@Override
	public List<String> getArticleList() {
		return databaseService.selectAll();
	}

	@Override
	public boolean createArticle(String subject, String content) {
		return databaseService.create(subject, content);
	}

	@Override
	public String getArticle(String subject) {
		return databaseService.selectOne(subject);
	}

	@Override
	public boolean updateArticle(String subject, String content) {
		return databaseService.update(subject, content);
	}

}
