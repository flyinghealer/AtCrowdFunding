package com.lx.atcrowdfunding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.lx.atcrowdfunding.bean.Permission;

public interface PermissionDao {
	
	@Select("select * from t_permission where pid is null")
	Permission queryRootPermission();
	
	@Select("select * from t_permission where pid = #{pid}")
	List<Permission> queryChildPermissions(Integer pid);
	
	@Select("select * from t_permission")
	List<Permission> queryAll();

	void insertPermission(Permission permission);
	
	@Select("select * from t_permission where id = #{id}")
	Permission queryById(Integer id);

	void updatePermission(Permission permission);
		
	void deletePermission(Integer id);

}
