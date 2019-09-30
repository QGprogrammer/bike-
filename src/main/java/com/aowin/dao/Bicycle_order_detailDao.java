package com.aowin.dao;

import java.util.List;

import com.aowin.model.Bicycle_order_detail;

/**
 * 采购明细单的数据库操作
 * @author Peter
 *
 */
public interface Bicycle_order_detailDao {

	/**
	 * 新增明细单
	 */
	int addBicycle_order_detail(Bicycle_order_detail bicycle_order_detail);
	/**
	 * 查询某一采购主单的车辆编号List
	 */
	List<Long> getBicycle_codeListByOrder_id(Long order_id);
	/**
	 * 更新（完善）明细单
	 */
	int updateBicycle_order_detail(Bicycle_order_detail bicycle_order_detail);
}
