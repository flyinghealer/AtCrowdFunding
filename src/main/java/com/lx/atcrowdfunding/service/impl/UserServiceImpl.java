package com.lx.atcrowdfunding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lx.atcrowdfunding.bean.User;
import com.lx.atcrowdfunding.dao.UserDao;
import com.lx.atcrowdfunding.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	
	public List<User> queryAll() {
		return userDao.queryAll();
	}
	
	
}
