package com.lx.atcrowdfunding.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lx.atcrowdfunding.bean.AJAXResult;
import com.lx.atcrowdfunding.bean.Permission;
import com.lx.atcrowdfunding.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	
	@Autowired
	PermissionService permissionService;
	
	@RequestMapping("/index")
	public String index() {
		return "permission/index";
	
	}
	
	@ResponseBody
	@RequestMapping("/loadData")
	public Object loadData() {
		//1、普通方式查询许可数据，不具有通用性
		/*List<Permission> permissions = new ArrayList<Permission>();
		
		Permission root = permissionService.queryRootPermission();
		List<Permission> childPermissions = permissionService.queryChildPermissions(root.getId());
		
		for (Permission childpermission : childPermissions) {
			List<Permission> childChildPermissions = permissionService.queryChildPermissions(childpermission.getId());
			childpermission.setChildren(childChildPermissions);
		}
		
		root.setChildren(childPermissions);
		permissions.add(root);*/
		
		//2、递归方式查询许可数据
		/*
		Permission parent = new Permission();
		parent.setId(0);
		queryChildPermissions(parent);		
		return parent.getChildren();*/
		
		//3、嵌套for循环读取许可数据
		/*
		List<Permission> permissions = new ArrayList<Permission>();
		List<Permission> ps = permissionService.queryAll();
		//由子节点找其父节点
		for (Permission p : ps) {
			Permission child = p;//子节点
			if(p.getPid()==0) {
				permissions.add(p);
			}else {
				for (Permission innerpermission : ps) {
					if(child.getPid().equals(innerpermission.getId())) {
						Permission parent = innerpermission;//父节点
						parent.getChildren().add(child);//组合父子节点关系
						break;
					}
				}
			}
		}
		return permissions;*/
		
		//4、Map方式遍历
		List<Permission> permissions = new ArrayList<Permission>();
		List<Permission> ps = permissionService.queryAll();
		Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
		for (Permission p : ps) {
			permissionMap.put(p.getId(), p);
		}
		for (Permission p : ps) {
			Permission child = p;
			if(p.getPid()==0) {
				permissions.add(p);
			}else {
				Permission parent = permissionMap.get(child.getPid());
				parent.getChildren().add(child);
			}
		}
		return permissions;
	}
	
	/*
	 * 递归查询许可信息
	 */
	private void queryChildPermissions(Permission parent) {
		List<Permission> childPermissions = permissionService.queryChildPermissions(parent.getId());
		
		for (Permission permission : childPermissions) {
			queryChildPermissions(permission);
		}
		
		parent.setChildren(childPermissions);
	}
	
	@RequestMapping("/add")
	public String add() {
		return "permission/add";
	
	}
	
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert(Permission permission) {
		AJAXResult result = new AJAXResult();
		try {
			
			permissionService.insertPermission(permission);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
	
	@RequestMapping("/edit")
	public String edit(Integer id, Model model) {
		Permission permission = permissionService.queryById(id);
		model.addAttribute("permission", permission);
		return "permission/edit";
	
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Object update(Permission permission) {
		AJAXResult result = new AJAXResult();
		try {
			
			permissionService.updatePermission(permission);
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
			
			permissionService.deletePermission(id);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}

}
