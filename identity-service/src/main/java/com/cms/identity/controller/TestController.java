package com.cms.identity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class TestController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome!! This is Identity Service.";
	}
}
