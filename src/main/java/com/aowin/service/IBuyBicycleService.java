package com.aowin.service;

import java.util.List;

import com.aowin.model.Bicycle_catagory;
import com.aowin.model.Bicycle_deal;
import com.aowin.model.Bicycle_info;
import com.aowin.model.Bicycle_order;
import com.aowin.model.Bicycle_order_detail;
import com.aowin.model.Vender;

/**
 * 购车的service
 * @author Peter
 *
 */
public interface IBuyBicycleService {
	/**
	 * 查询供应商List
	 */
	List<Vender> getVenderList();
	/**
	 * 新增采购主单
	 */
	void addBicycle_order(Bicycle_order bicycle_order,Bicycle_order_detail bicycle_order_detail, List<Bicycle_info> bicycle_infoList, Bicycle_deal bicycle_deal);
	/**
	 * 获得车辆信息中最大的车辆编号
	 */
	String getMaxBicycleCode();
	/**
	 * 查询全部采购主单
	 */
	List<Bicycle_order> getBicycle_orderList();
	/**
	 * 查询某一采购主单的车辆编号List
	 */
	List<Long> getBicycle_codeListByOrder_id(Long order_id);
	/**
	 * 查询车辆类型的全部信息List
	 */
	List<Bicycle_catagory> getBicycle_catagoryList();
	/**
	 * 更新（完善）明细单
	 */
	int updateBicycle_order_detail(Bicycle_order_detail bicycle_order_detail);
	
}
