package com.cms.student.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class TestController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to the CMS. This is Student Service.";
	}
}
