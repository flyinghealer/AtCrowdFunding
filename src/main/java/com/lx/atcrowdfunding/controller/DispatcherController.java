package com.lx.atcrowdfunding.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lx.atcrowdfunding.bean.AJAXResult;
import com.lx.atcrowdfunding.bean.User;
import com.lx.atcrowdfunding.service.UserService;

@Controller
public class DispatcherController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/dologin")
	public String dologin(User user,Model model) {
		/*
		 * 获取表单值的三种方式：
		 * 1、HttpServletRequest
		 * 2、在方法参数列表中增加表单对应的参数，名称相同
		 * 3、将表单数据封装成实体类对象
		 */
		
		User dbUser = userService.query4Login(user);
		
		if(dbUser==null) {
			String errorMsg = "登陆账号或密码不正确，请重新输入";
			model.addAttribute("errorMsg", errorMsg);
			return "redirect:login";
		}else {
			return "main";
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/doAJAXLogin")
	public Object doAJAXLogin(User user,HttpSession session) {
		AJAXResult result = new AJAXResult();
		User dbUser = userService.query4Login(user);
		if(dbUser==null) {
			result.setSuccess(false);
		}else {
			session.setAttribute("loginUser",dbUser);
			result.setSuccess(true);
		}
		return result;
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("loginUser");
		session.invalidate();//可以一次性将session中所有的数据都删除掉，不用一个一个的去remove
		return "redirect:login";
	}
	
	
	
}
