package com.aowin.service;

import java.util.List;

import com.aowin.model.Bicycle_catagory;
import com.aowin.model.Bicycle_pile;
import com.aowin.model.Bicycle_station;

/**
 * 车点车辆信息查询的service
 * @author Peter
 *
 */
public interface IBicycle_stationInformationService {
	/**
	 * 根据车点名称、地址模糊查询出详细信息（车点、车桩信息联合查询）
	 */
	public List<Bicycle_station> getBicycle_stationListByNameOrAdd(Bicycle_station bicycle_station);
	/**
	 * 根据车点经纬度查询车桩的集合
	 */
	List<Bicycle_pile> getBicycle_pileListByLogAndLat(Bicycle_station bicycle_station);
	/**
	 * 根据车辆id查询车辆信息
	 * @param bicycle_id
	 * @return
	 */
	Bicycle_catagory getBicycle_catagoryById(Integer bicycle_id);
}
