package com.aowin.dao;

import java.util.List;

import com.aowin.model.SyUser;

/**
 * 用户类的数据库操作
 * @author Peter
 *
 */
public interface SyUserDao {

	/**
	 * 根据登录名+密码获得用户名（登录验证）
	 */
	SyUser checkSyUser(SyUser syUser);
	/**
	 * 用户登录名校验
	 */
	SyUser checkLogin_name(String login_name);
	/**
	 * 模糊查询用户List
	 */
	List<SyUser> getSyUserList(SyUser syUser);
	/**
	 * 新增用户
	 */
	int addSyUser(SyUser syUser);
	/**
	 * 注销用户
	 */
	int cancelSyUser(Integer user_id);
	/**
	 * 查询用户详细信息
	 */
	SyUser getSyUser(Integer user_id);
	/**
	 * 修改用户信息
	 */
	int updateSyUser(SyUser syUser);
	/**
	 * 删除角色判断 查看用户表中某角色id的条数 一条即可
	 */
	int getRoleCountBySyUser(Integer role_id);
}
