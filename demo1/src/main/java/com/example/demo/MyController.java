package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.board.BoardService;
import com.example.demo.service.database.DatabaseService;

@Controller
public class MyController {
	// 의존성 주입 (런타임에 결정)
	@Autowired
	private DatabaseService databaseService;
	@Autowired
	private BoardService boardService;

	@RequestMapping("/hello")
	public String hello(@RequestParam String name, Model model /* 모델 : 데이터 --> view 로 넘기는 데이터 */) {
		model.addAttribute("name", databaseService.saveName(name));
		return "hello";	// 템플릿 이름
	}
	
	// CRUD - 게시판
	
	// Create
	@ResponseBody
	@RequestMapping("/write")
	public boolean write(@RequestParam String subject, @RequestParam String content) {
		return boardService.createArticle(subject, content);
	}
	
	// Read
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("users", boardService.getArticleList());
		return "board";
	}
	
	// Read
	@ResponseBody	// 리턴값을 템플릿이름이 아니라 응답의 바디로 쓸것이다는 어노테이션
	@RequestMapping("/post")
	public String post(@RequestParam String subject) {
		return boardService.getArticle(subject);		// 값
	}
	
	// Update
	@ResponseBody	// 리턴값을 템플릿이름이 아니라 응답의 바디로 쓸것이다는 어노테이션
	@RequestMapping("/update")
	public boolean update(@RequestParam String subject, @RequestParam String content) {
		return boardService.updateArticle(subject, content);
	}
	
}
