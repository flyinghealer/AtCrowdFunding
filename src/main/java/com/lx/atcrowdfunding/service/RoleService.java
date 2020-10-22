package com.lx.atcrowdfunding.service;

import java.util.List;
import java.util.Map;

import com.lx.atcrowdfunding.bean.Role;

public interface RoleService {
	
	List<Role> pageQueryData(Map<String, Object> map);
	
	int PageQueryCount(Map<String, Object> map);

	List<Role> queryAll();

}
