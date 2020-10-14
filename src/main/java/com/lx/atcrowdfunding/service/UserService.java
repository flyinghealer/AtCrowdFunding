package com.lx.atcrowdfunding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lx.atcrowdfunding.bean.User;
import com.lx.atcrowdfunding.dao.UserDao;


public interface UserService {

	List<User> queryAll();

	//List<User> queryAll();
	
	
}
