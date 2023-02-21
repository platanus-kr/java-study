package com.example.securitytest2.controller;

import com.example.securitytest2.config.LoginMember;
import com.example.securitytest2.config.SessionMember;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nice")
public class NiceController {

	/**
	 * No Authentication
	 * @return
	 */
	@GetMapping("/test")
	public String test() {
		return "test";
	}

	/**
	 * Use Authorization!!!
	 * @return
	 */
	@GetMapping("/auth")
	public String requiredAuth(Model model, @LoginMember SessionMember sMember) {
		model.addAttribute("member", sMember);
		return "required_auth";
	}
}
