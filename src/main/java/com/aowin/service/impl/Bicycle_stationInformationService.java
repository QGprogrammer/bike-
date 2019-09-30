package com.aowin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aowin.dao.Bicycle_catagoryDao;
import com.aowin.dao.Bicycle_pileDao;
import com.aowin.dao.Bicycle_stationDao;
import com.aowin.model.Bicycle_catagory;
import com.aowin.model.Bicycle_pile;
import com.aowin.model.Bicycle_station;
import com.aowin.service.IBicycle_stationInformationService;

/**
 * 车辆车点信息查询的service实现类
 * @author Peter
 *
 */
@Service
public class Bicycle_stationInformationService implements IBicycle_stationInformationService {
	
	@Resource
	private Bicycle_stationDao bicycle_stationDao;
	@Resource
	private Bicycle_pileDao bicycle_pileDao;
	@Resource
	private Bicycle_catagoryDao bicycle_catagoryDao;
	/**
	 * 获取车点的信息 模糊查询
	 * @author Peter
	 *
	 */
	public List<Bicycle_station> getBicycle_stationListByNameOrAdd(Bicycle_station bicycle_station) {
		return bicycle_stationDao.getBicycle_stationListByNameOrAdd(bicycle_station);
	}
	/**
	 * 根据车点经纬度查询车桩的集合
	 */
	public List<Bicycle_pile> getBicycle_pileListByLogAndLat(Bicycle_station bicycle_station){
		return bicycle_pileDao.getBicycle_pileListByLogAndLat(bicycle_station);
	}
	/**
	 * 根据车辆id查询车辆信息
	 * @param bicycle_id
	 * @return
	 */
	public Bicycle_catagory getBicycle_catagoryById(Integer bicycle_id) {
		return bicycle_catagoryDao.getBicycle_catagoryById(bicycle_id);
		
	}

}
