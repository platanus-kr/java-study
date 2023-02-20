package com.example.securitytest2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nice")
public class NiceController {

	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@GetMapping("/auth")
	public String requiredAuth(@AuthenticationPrincipal OAuth2User principal) {

		return "required_auth";
	}
}
