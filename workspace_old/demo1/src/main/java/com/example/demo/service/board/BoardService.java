package com.example.demo.service.board;

import java.util.List;

public interface BoardService {
	
	public List<String> getArticleList();
	
	public boolean createArticle(String subject, String content);

	public String getArticle(String subject);
	
	public boolean updateArticle(String subject, String content);
	
}
