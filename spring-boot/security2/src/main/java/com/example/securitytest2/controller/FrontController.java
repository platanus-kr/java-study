package com.example.securitytest2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.securitytest2.model.SessionMemberDto;

@Controller
@RequestMapping("/")
public class FrontController {
	
	@GetMapping
	public String front() {
		return "front";
	}
	
}
