package com.lx.atcrowdfunding.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lx.atcrowdfunding.bean.Role;
import com.lx.atcrowdfunding.dao.RoleDao;
import com.lx.atcrowdfunding.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> queryAll() {
		// TODO Auto-generated method stub
		return roleDao.queryAll();
	}

	@Override
	public List<Role> pageQueryData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return roleDao.pageQueryData(map);
	}

	@Override
	public int PageQueryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return roleDao.PageQueryCount(map);
	}

}
