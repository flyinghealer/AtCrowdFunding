package com.lx.atcrowdfunding.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.lx.atcrowdfunding.bean.Role;

public interface RoleDao {
	
	@Select("select * from t_role")
	public List<Role> queryAll() ;

	public List<Role> pageQueryData(Map<String, Object> map);

	public int PageQueryCount(Map<String, Object> map);

}
