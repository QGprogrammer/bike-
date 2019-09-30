package com.aowin.service;


/**
 * 用户授权的service
 * @author Peter
 *
 */
public interface ISyPermissionService {

	/**
	 * 查找授权表中对应的权限记录数（删除时判断）
	 */
	Integer getMsPhaseCount(Integer phaseid);
}
