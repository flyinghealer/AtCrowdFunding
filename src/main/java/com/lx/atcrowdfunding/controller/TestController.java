package com.lx.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lx.atcrowdfunding.bean.User;
import com.lx.atcrowdfunding.service.UserService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("json")
	public Object json() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username","张三");
		return map;
	}
	
	@ResponseBody
	@RequestMapping("queryAll")
	public Object queryAll() {
		List<User> users = userService.queryAll();
		return users;
	}

}
