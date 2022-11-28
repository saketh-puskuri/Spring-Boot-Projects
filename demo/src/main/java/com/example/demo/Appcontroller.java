package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Appcontroller {
	@RequestMapping("/show")
	public String show() {
		return "show";
	}

}
