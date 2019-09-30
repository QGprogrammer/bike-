package com.aowin.dao;

import java.util.List;

import com.aowin.model.Bicycle_deploy;

/**
 * 车类调度的数据库操作
 * @author Peter
 *
 */
public interface Bicycle_deployDao {

	/**
	 * 新增调度记录
	 */
	int addBicycle_deploy(List<Bicycle_deploy> list);
}
