package com.aowin.dao;

import java.util.List;

import com.aowin.model.Bicycle_info;
import com.aowin.model.Bicycle_pile;

/**
 * 车辆信息的数据库操作
 * @author Peter
 *
 */
public interface Bicycle_infoDao {

	/**
	 * 查找车辆编码做大值
	 */
	String getMaxBicycleCode();
	/**
	 * 批量新增车辆信息
	 */
	int addBicycle_info(List<Bicycle_info> list);
	/**
	 * 带状态查询车辆id和车辆编号
	 */
	List<Bicycle_info> getBicycle_infoByStatus(Integer status);
	/**
	 * 车辆批量入桩
	 */
	int updateBicycle_infoByInstation(List<Bicycle_pile> list);
	
}
