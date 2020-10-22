package com.lx.atcrowdfunding.service.impl;

import java.util.List;
import java.util.Map;

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


	@Override
	public User query4Login(User user) {
		// TODO Auto-generated method stub
		return userDao.query4Login(user);
	}


	@Override
	public List<User> pageQueryData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.pageQueryData(map);
	}


	@Override
	public int pageQueryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.pageQueryCount(map);
	}


	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
	}


	@Override
	public User queryById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.queryById(id);
	}


	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}


	@Override
	public void deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		userDao.deleteUserById(id);
	}


	@Override
	public void deleteUsers(Map<String, Object> map) {
		// TODO Auto-generated method stub
		userDao.deleteUsers(map);
	}


	@Override
	public void insertUserRoles(Map<String, Object> map) {
		// TODO Auto-generated method stub
		userDao.insertUserRoles(map);
	}


	@Override
	public void deleteUserRoles(Map<String, Object> map) {
		// TODO Auto-generated method stub
		userDao.deleteUserRoles(map);
	}


	@Override
	public List<Integer> queryRoleidsByUserid(Integer id) {
		// TODO Auto-generated method stub
		return userDao.queryRoleidsByUserid(id);
	}
	
	
}
