package com.aowin.service;


import java.util.List;

import com.aowin.model.SyUser;

/**
 * 用户管理的service接口
 * @author Peter
 *
 */
public interface ISyUserService {

	/**
	 * 用户登录校验
	 */
	SyUser checkSyUser(SyUser syUser);
	/**
	 * 登录名校验
	 */
	SyUser checkLogin_name(String login_name);
	/**
	 * 模糊查询用户List
	 */
	List<SyUser> getSyUserList(SyUser syUser);
	/**
	 * 用户新增
	 */
	int addSyUser(SyUser syUser);
	/**
	 * 注销用户
	 */
	int cancelSyUser(Integer user_id);
	/**
	 * 查询用户信息
	 */
	SyUser getSyUser(Integer user_id);
	/**
	 * 修改用户信息
	 */
	int updateSyUser(SyUser syUser);
}
