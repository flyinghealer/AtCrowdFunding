package com.lx.atcrowdfunding.bean;

public class User {
	
	private int id;
	private String username;
	
	public User() {}//必须添加无参构造，因为mybatis框架在初始化bean的时候需要无参构造器，写了有参构造器，会把无参构造器覆盖掉，需要在pojo中加上一个无参构造。
	public User(int id, String username) {
		
		this.id = id;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
