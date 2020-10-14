package com.lx.atcrowdfunding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DispatcherController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
