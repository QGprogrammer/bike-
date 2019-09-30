package com.aowin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.SyPermissionDao;
import com.aowin.dao.SyRoleDao;
import com.aowin.dao.SyUserDao;
import com.aowin.model.SyRole;
import com.aowin.service.ISyRoleService;

/**
 * 角色service的实现类
 * @author Peter
 *
 */
@Service
public class SyRoleService implements ISyRoleService {
	
	@Resource
	private SyRoleDao syRoleDao;
	@Resource
	private SyPermissionDao syPermissionDao;
	@Resource
	private SyUserDao syUserDao;
	/**
	 * 查询某角色id的权限
	 */
	public SyRole getRoleSyPermission(Integer roleid) {
		return syRoleDao.getRoleSyPermission(roleid);
	}
	/**
	 * 查询某个角色的全部信息
	 */
	public SyRole getSyRole(Integer roleid) {
		return syRoleDao.getSyRole(roleid);
	}
	/**
	 * 校验角色是否存在
	 */
	public SyRole checkSyRole(String role_name) {
		return syRoleDao.checkSyRole(role_name);
	} 
	/**
	 * 模糊查询角色信息List
	 */
	public List<SyRole> getSyRoleList(SyRole syRole){
		return syRoleDao.getSyRoleList(syRole);
	}
	/**
	 * 修改某角色的全部权限 事务处理
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateMsPhaseOfRole(SyRole syRole) {
		//更改角色基本信息
		syRoleDao.updateSyRole(syRole);
		// 删除全部权限
		syPermissionDao.deleteMsPhaseOfRole(syRole.getRole_id());
		// 添加修改后的权限
		if (syRole.getMsPhaseList().size() != 0) {
			syPermissionDao.addMsPhaseOfRole(syRole);			
		}
	}
	/**
	 * 新增角色
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void addSyRole(SyRole syRole) {
		//新增角色基本信息
		syRoleDao.addSyRole(syRole);
		//新增角色权限信息
		if (syRole.getMsPhaseList().size() != 0) {
			syPermissionDao.addMsPhaseOfRole(syRole);			
		}
	}
	/**
	 * 删除角色
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteSyRole(Integer role_id){
		//删除sypermission中的角色授权信息
		syPermissionDao.deleteMsPhaseOfRole(role_id);
		//删除syrole中的基本信息
		syRoleDao.deleteSyRole(role_id);
	}
	/**
	 * 删除角色判断 查看用户表中某角色id的条数 一条即可
	 */
	public int getRoleCountBySyUser(Integer role_id) {
		return syUserDao.getRoleCountBySyUser(role_id);	
	}
	
}
