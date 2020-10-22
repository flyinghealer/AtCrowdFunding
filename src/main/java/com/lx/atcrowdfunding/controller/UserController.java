package com.lx.atcrowdfunding.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lx.atcrowdfunding.bean.AJAXResult;
import com.lx.atcrowdfunding.bean.Page;
import com.lx.atcrowdfunding.bean.Role;
import com.lx.atcrowdfunding.bean.User;
import com.lx.atcrowdfunding.service.RoleService;
import com.lx.atcrowdfunding.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService RoleService;
	
	@RequestMapping("index")
	public String index() {
		return "user/index";
	}
	
	@ResponseBody
	@RequestMapping("/pageQuery")
	public Object pageQuery(Integer pageno,Integer pagesize,String queryText) {
		AJAXResult result = new AJAXResult();
		try {
			//分页查询
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", (pageno-1)*pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);
			List<User> users = userService.pageQueryData(map);
			
			//总数据条数
			int totalsize = userService.pageQueryCount(map);
			//最大页码（总页码）
			int totalno = 0;
			if(totalsize%pagesize==0) {
				totalno = totalsize/pagesize;
			}else {
				totalno = totalsize/pagesize+1;
			}
			
			Page<User> userPage = new Page<User>();
			userPage.setDatas(users);
			userPage.setTotalno(totalno);
			userPage.setTotalsize(totalsize);
			userPage.setPageno(pageno);
			
			result.setData(userPage);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
	
	/*
	 * 用户首页,已不使用这种
	 */
	//给参数添加默认值是为了开始时点击用户维护直接显示第一页的数据，而不需要点击页码给后台传递数据
	@RequestMapping("/index1")
	public String index1(@RequestParam(required=false,defaultValue="1")Integer pageno,@RequestParam(required=false,defaultValue="10")Integer pagesize,Model model) {
		//分页查询
		//limit start,size
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", (pageno-1)*pagesize);
		map.put("size", pagesize);
		List<User> users = userService.pageQueryData(map);
		model.addAttribute("users", users);
		//当前页，用户判断是否还有前一页，后一页
		model.addAttribute("pageno", pageno);
		//总数据条数
		int totalsize = userService.pageQueryCount(map);
		//最大页码（总页码）
		int totalno = 0;
		if(totalsize%pagesize==0) {
			totalno = totalsize/pagesize;
		}else {
			totalno = totalsize/pagesize+1;
		}
		model.addAttribute("totalno", totalno);
		return "user/index";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "user/add";
	}
	
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert(User user) {
		AJAXResult result = new AJAXResult();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			user.setUserpswd("123456");
			user.setCreatetime(sdf.format(new Date()));
			userService.insertUser(user);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}		
		return result;
	}
	
	@RequestMapping("/edit")
	public String edit(Integer id,Model model) {
		User user = userService.queryById(id);
		model.addAttribute("user", user);
		return "user/edit";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Object update(User user) {
		AJAXResult result = new AJAXResult();
		try {

			userService.updateUser(user);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object delete(Integer id) {
		AJAXResult result = new AJAXResult();
		try {

			userService.deleteUserById(id);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/deletes")
	public Object deletes(Integer[] userid) {
		AJAXResult result = new AJAXResult();
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("userids", userid);
			userService.deleteUsers(map);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}		
		return result;
	}
	
	@RequestMapping("/assign")
	public String assign(Integer id,Model model) {
		User user = userService.queryById(id);
		model.addAttribute("user", user);
		
		List<Role> roles = RoleService.queryAll();//所有的角色
		
		List<Role> assignedRoles = new ArrayList<Role>();//已分配的角色
		List<Role> unassignedRoles = new ArrayList<Role>();//未分配的角色
		
		List<Integer> roleids = userService.queryRoleidsByUserid(id);//查询该用户已经被分配了哪些角色
		for(Role role : roles) {
			if(roleids.contains(role.getId())) {
				assignedRoles.add(role);
			}else {
				unassignedRoles.add(role);
			}
		}
			
		model.addAttribute("assignedRoles", assignedRoles);
		model.addAttribute("unassignedRoles", unassignedRoles);
		return "user/assign";
	}
	
	@ResponseBody
	@RequestMapping("/doAssign")
	public Object doAssign(Integer userid,Integer[] unassignroleids) {
		AJAXResult result = new AJAXResult();
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("userid", userid);
			map.put("roleids", unassignroleids);
			userService.insertUserRoles(map);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/dounAssign")
	public Object dounAssign(Integer userid,Integer[] assignroleids) {
		AJAXResult result = new AJAXResult();
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("userid", userid);
			map.put("roleids", assignroleids);
			userService.deleteUserRoles(map);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}		
		return result;
	}
	
	
	
	
}
