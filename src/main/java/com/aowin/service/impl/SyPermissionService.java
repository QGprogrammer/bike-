package com.aowin.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aowin.dao.SyPermissionDao;
import com.aowin.dao.SyRoleDao;
import com.aowin.service.ISyPermissionService;

/**
 * 用户授权service的实现类
 * 
 * @author Peter
 *
 */
@Service
public class SyPermissionService implements ISyPermissionService {
	@Resource
	private SyPermissionDao syPermissionDao;
	@Resource
	private SyRoleDao syRoleDao;

	/**
	 * 查找授权表中对应的权限记录数（删除时判断）
	 */
	public Integer getMsPhaseCount(Integer phaseid) {
		return syPermissionDao.getMsPhaseCount(phaseid);
	}
}
