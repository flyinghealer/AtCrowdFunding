package com.lx.atcrowdfunding.bean;

public class User {
	
	private int id;
	private String username;
	private String loginacct;
	private String userpswd;
	private String email;
	private String createtime;
	
	public User() {}//必须添加无参构造，因为mybatis框架在初始化bean的时候需要无参构造器，写了有参构造器，会把无参构造器覆盖掉，需要在pojo中加上一个无参构造。
	
	

	public User(int id, String username, String loginacct, String userpswd, String email, String createtime) {
		super();
		this.id = id;
		this.username = username;
		this.loginacct = loginacct;
		this.userpswd = userpswd;
		this.email = email;
		this.createtime = createtime;
	}



	public String getLoginacct() {
		return loginacct;
	}
	public void setLoginacct(String loginacct) {
		this.loginacct = loginacct;
	}
	public String getUserpswd() {
		return userpswd;
	}
	public void setUserpswd(String userpswd) {
		this.userpswd = userpswd;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
}
