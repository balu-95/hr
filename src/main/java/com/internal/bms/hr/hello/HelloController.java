package com.internal.bms.hr.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	private String hello() {
		
		return "Welcome to HR portal";
	}
}
