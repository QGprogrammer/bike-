package com.aowin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aowin.dao.SyUserDao;
import com.aowin.model.SyUser;
import com.aowin.service.ISyUserService;

/**
 * 用户管理service的实现类
 * @author Peter
 *
 */
@Service
public class SyUserService implements ISyUserService {

	/**
	 * 用户的数据库Dao
	 */
	@Resource
	private SyUserDao syUserDao;
	/**
	 * 用户登录校验
	 */
	public SyUser checkSyUser(SyUser syUser) {
		return syUserDao.checkSyUser(syUser);
	}
	/**
	 * 登录名校验
	 */
	public SyUser checkLogin_name(String login_name) {
		return syUserDao.checkLogin_name(login_name);
	}
	/**
	 * 模糊查询用户List
	 */
	public List<SyUser> getSyUserList(SyUser syUser){
		return syUserDao.getSyUserList(syUser);
	}
	/**
	 * 用户新增
	 */
	public int addSyUser(SyUser syUser) {
		return syUserDao.addSyUser(syUser);
	}
	/**
	 * 注销用户
	 */
	public int cancelSyUser(Integer user_id) {
		return syUserDao.cancelSyUser(user_id);
	}
	/**
	 * 查询用户信息
	 */
	public SyUser getSyUser(Integer user_id) {
		return syUserDao.getSyUser(user_id);
	}
	/**
	 * 修改用户信息
	 */
	public int updateSyUser(SyUser syUser) {
		return syUserDao.updateSyUser(syUser);
	}

}
