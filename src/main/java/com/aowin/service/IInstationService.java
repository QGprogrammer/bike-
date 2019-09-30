package com.aowin.service;

import java.util.List;

import com.aowin.model.Bicycle_deploy;
/**
 * 新车入桩的service
 */
import com.aowin.model.Bicycle_info;
import com.aowin.model.Bicycle_pile;
import com.aowin.model.Bicycle_station;

/**
 * 车辆入桩的控制器
 * @author Peter
 *
 */
public interface IInstationService {
	/**
	 * 带状态查询车辆id和车辆编号
	 */
	List<Bicycle_info> getBicycle_infoByStatus(Integer status);
	/**
	 *	查询车店信息（id、名字）
	 */
	List<Bicycle_station> getBicycle_stationList();
	/**
	 * 查询某车点的车桩信息
	 */
	List<Bicycle_pile> getBicycle_pileListByStationId(Integer station_id, Integer status);
	/**
	 * 车辆批量入桩
	 */
	void instationByBatch(List<Bicycle_pile> bicycle_pileList, List<Bicycle_deploy> bicycle_deployList);
	
}
