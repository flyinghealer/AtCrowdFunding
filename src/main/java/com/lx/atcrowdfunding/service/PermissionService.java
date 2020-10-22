package com.lx.atcrowdfunding.service;

import java.util.List;

import com.lx.atcrowdfunding.bean.Permission;

public interface PermissionService {

	Permission queryRootPermission();

	List<Permission> queryChildPermissions(Integer pid);

	List<Permission> queryAll();

	void insertPermission(Permission permission);

	Permission queryById(Integer id);

	void updatePermission(Permission permission);

	void deletePermission(Integer id);

	

}
