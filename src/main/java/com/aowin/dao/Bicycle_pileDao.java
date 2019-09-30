package com.aowin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aowin.model.Bicycle_pile;
import com.aowin.model.Bicycle_station;

/**
 * 车桩的数据库操作
 * @author Peter
 *
 */
public interface Bicycle_pileDao {

	/**
	 * 查询某站点的车桩集合
	 */
	List<Bicycle_pile> getBicycle_pileListByStationId(@Param("station_id") Integer station_id, @Param("status")Integer status);
	/**
	 * 更新某车桩的状态（新车入桩）
	 */
	int updateBicycle_pileStatus(List<Bicycle_pile> list);
	/**
	 * 根据车点经纬度查询车桩的集合
	 */
	List<Bicycle_pile> getBicycle_pileListByLogAndLat(Bicycle_station bicycle_station);
}
