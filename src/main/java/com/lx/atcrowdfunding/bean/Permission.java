package com.lx.atcrowdfunding.bean;

import java.util.ArrayList;
import java.util.List;

public class Permission {
	
	private Integer id;
	private String name;
	private String url;
	private Integer pid;
	private boolean open =true;
	private List<Permission> children = new ArrayList<Permission>();
	
	public Permission() {}

	public Permission(Integer id, String name, String url, Integer pid, boolean open, List<Permission> children) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.pid = pid;
		this.open = open;
		this.children = children;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public List<Permission> getChildren() {
		return children;
	}

	public void setChildren(List<Permission> children) {
		this.children = children;
	}
	
	
}
