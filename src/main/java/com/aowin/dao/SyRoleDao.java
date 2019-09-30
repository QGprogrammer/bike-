package com.aowin.dao;

import java.util.List;

import com.aowin.model.SyRole;

/**
 * 角色类的数据库操作
 * @author Peter
 *
 */
public interface SyRoleDao {

	/**
	 * 查询某个角色的授权
	 */
	SyRole getRoleSyPermission(Integer roleid);
	/**
	 * 查询某个角色的全部信息
	 */
	SyRole getSyRole(Integer roleid);
	/**
	 * 校验角色名是否存在
	 */
	SyRole checkSyRole(String role_name);
	/**
	 * 模糊查询角色信息List
	 */
	List<SyRole> getSyRoleList(SyRole syRole);
	/**
	 * 更改角色信息（role_name\role_description）
	 */
	int updateSyRole(SyRole syRole);
	/**
	 * 新增角色基本信息
	 */
	int addSyRole(SyRole syRole);
	/**
	 * 删除某角色基本信息
	 */
	int deleteSyRole(Integer role_id);
}
