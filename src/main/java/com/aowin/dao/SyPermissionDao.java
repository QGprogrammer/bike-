package com.aowin.dao;

import com.aowin.model.SyRole;

/**
 * 用户权限类的数据库操作
 * @author Peter
 *
 */
public interface SyPermissionDao {

	/**
	 * 查找授权表中对应的权限记录数（删除时判断）
	 */
	Integer getMsPhaseCount(Integer phaseid);
	/**
	 * 删除某角色的全部权限
	 */
	int deleteMsPhaseOfRole(Integer roleid);
	/**
	 * 为某角色分配权限
	 */
	int addMsPhaseOfRole(SyRole syRole);
}
