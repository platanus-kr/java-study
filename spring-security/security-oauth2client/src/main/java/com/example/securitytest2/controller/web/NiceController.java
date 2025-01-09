package com.example.securitytest2.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.securitytest2.argumentresolver.HasMember;
import com.example.securitytest2.config.dto.SessionMemberDto;

@Controller
@RequestMapping("/nice")
public class NiceController {

	/**
	 * No Authentication
	 * @return
	 */
	@GetMapping("/test")
	public String test(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return "test";
	}

	/**
	 * Use Authorization!!!
	 * @return
	 */
	@GetMapping("/auth")
	public String requiredAuth(Model model, @HasMember SessionMemberDto member, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("member", member);
		return "required_auth";
	}
}
