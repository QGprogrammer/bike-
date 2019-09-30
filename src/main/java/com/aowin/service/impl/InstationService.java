package com.aowin.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.Bicycle_dealDao;
import com.aowin.dao.Bicycle_deployDao;
import com.aowin.dao.Bicycle_infoDao;
import com.aowin.dao.Bicycle_pileDao;
import com.aowin.dao.Bicycle_stationDao;
import com.aowin.model.Bicycle_deal;
import com.aowin.model.Bicycle_deploy;
import com.aowin.model.Bicycle_info;
import com.aowin.model.Bicycle_pile;
import com.aowin.model.Bicycle_station;
import com.aowin.service.IInstationService;

/**
 * 新车入桩的service实现类
 * @author Peter
 *
 */
@Service
public class InstationService implements IInstationService{
	@Resource
	private Bicycle_infoDao bicycle_infoDao;
	@Resource
	private Bicycle_stationDao bicycle_stationDao;
	@Resource
	private Bicycle_pileDao bicycle_pileDao;
	@Resource
	private Bicycle_deployDao bicycle_deployDao;
	@Resource
	private Bicycle_dealDao bicycle_dealDao;
	/**
	 * 带状态查询车辆id和车辆编号
	 */
	public List<Bicycle_info> getBicycle_infoByStatus(Integer status) {
		return bicycle_infoDao.getBicycle_infoByStatus(status);
	}
	/**
	 *	查询车店信息（id、名字）
	 * @return
	 */
	public List<Bicycle_station> getBicycle_stationList(){
		return bicycle_stationDao.getBicycle_stationList();
	}
	/**
	 * 查询某车点的车桩信息
	 */
	public List<Bicycle_pile> getBicycle_pileListByStationId(Integer station_id, Integer status){
		return bicycle_pileDao.getBicycle_pileListByStationId(station_id, status);
	}
	/**
	 * 车辆批量入桩
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void instationByBatch(List<Bicycle_pile> bicycle_pileList, List<Bicycle_deploy> bicycle_deployList) {
		bicycle_pileDao.updateBicycle_pileStatus(bicycle_pileList);  //车桩状态
		bicycle_infoDao.updateBicycle_infoByInstation(bicycle_pileList);  //车辆状态
		bicycle_deployDao.addBicycle_deploy(bicycle_deployList);  //调度记录
		List<Bicycle_deal> i =  getBicycle_dealListFromBicycle_pileList(bicycle_deployList);
		System.out.println(i);
		bicycle_dealDao.addBicycle_dealByBicycle_deploy(i);  //流水记录
	}
	/**
	 * 由bicycle_deploy集合获得bicycle_deal集合
	 */
	private List<Bicycle_deal> getBicycle_dealListFromBicycle_pileList(List<Bicycle_deploy> list){
		List<Bicycle_deal> bicycle_dealList = new ArrayList<Bicycle_deal>();
		for(Bicycle_deploy dep : list) {
			Bicycle_deal deal = new Bicycle_deal();
			deal.setCreate_time(dep.getTo_time());
			deal.setDeal_name("普通调入");
			deal.setDeal_type(5);
			deal.setRecord_id(dep.getDeploy_id());
			deal.setChg_money(0d);
			deal.setIs_fee(0);
			bicycle_dealList.add(deal);	
		}
		return bicycle_dealList;
	}

}
