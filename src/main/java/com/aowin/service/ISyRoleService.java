package com.aowin.service;

import java.util.List;

import com.aowin.model.SyRole;

/**
 * 角色的service
 * @author Peter
 *
 */
public interface ISyRoleService {

	/**
	 * 查询某角色id的权限
	 */
	SyRole getRoleSyPermission(Integer roleid);
	/**
	 * 查询某个角色的全部信息
	 */
	SyRole getSyRole(Integer roleid);
	/**
	 * 校验角色是否存在
	 */
	SyRole checkSyRole(String role_name);
	/**
	 * 模糊查询角色信息List
	 */
	List<SyRole> getSyRoleList(SyRole syRole);
	/**
	 * 修改某角色的全部权限 事务处理
	 */
	void updateMsPhaseOfRole(SyRole syRole);
	/**
	 * 新增角色
	 */
	void addSyRole(SyRole syRole);
	/**
	 * 删除角色
	 */
	void deleteSyRole(Integer role_id);
	/**
	 * 删除角色判断 查看用户表中某角色id的条数 一条即可
	 */
	int getRoleCountBySyUser(Integer role_id);
}
