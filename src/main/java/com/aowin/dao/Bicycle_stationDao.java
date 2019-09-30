package com.aowin.dao;

import java.util.List;

import com.aowin.model.Bicycle_station;

/**
 * 车辆站点的数据库操作
 * @author Peter
 *
 */
public interface Bicycle_stationDao {
	/**
	 *	查询车店信息（id、名字）
	 * @return
	 */
	public List<Bicycle_station> getBicycle_stationList();
	/**
	 * 根据车点名称、地址模糊查询出详细信息（车点、车桩信息联合查询）
	 */
	public List<Bicycle_station> getBicycle_stationListByNameOrAdd(Bicycle_station bicycle_station);
}
