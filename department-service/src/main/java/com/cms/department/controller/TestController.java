package com.cms.department.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class TestController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome!! This is Department Service.";
	}
}
