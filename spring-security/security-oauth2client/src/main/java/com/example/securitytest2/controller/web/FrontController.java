package com.example.securitytest2.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FrontController {

	/**
	 * No Authentication
	 * @return
	 */
	@GetMapping
	public String front() {
		return "front";
	}
	
}
