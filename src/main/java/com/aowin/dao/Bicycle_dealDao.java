package com.aowin.dao;

import java.util.List;

import com.aowin.model.Bicycle_deal;

/**
 * 车辆流水的数据库操作
 * @author Peter
 *
 */
public interface Bicycle_dealDao {
	/**
	 * 批量新增车辆流水
	 */
	int addBicycle_deal(Bicycle_deal bicycle_deal);
	/**
	 * 根据Bicycle_deal集合新增流水
	 */
	int addBicycle_dealByBicycle_deploy(List<Bicycle_deal> list);
}
