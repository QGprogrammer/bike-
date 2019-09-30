package com.aowin.dao;

import java.util.List;

import com.aowin.model.Bicycle_order;

/**
 * 采购主单的数据库操作
 * @author Peter
 *
 */
public interface Bicycle_orderDao {

	/**
	 * 新增采购主单
	 */
	int addBicycle_order(Bicycle_order bicycle_order);
	/**
	 * 查询采购主单
	 */
	List<Bicycle_order> getBicycle_orderList();
}
