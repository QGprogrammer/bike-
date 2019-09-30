package com.aowin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.model.Bicycle_deploy;
import com.aowin.model.Bicycle_info;
import com.aowin.model.Bicycle_pile;
import com.aowin.model.Bicycle_station;
import com.aowin.service.IInstationService;
import com.aowin.util.DateUtil;

/**
 * 新车入桩的控制器
 * 
 * @author Peter
 *
 */
@RequestMapping("instation")
@RestController
public class InstationController {
	@Resource
	private IInstationService instationService;
	@Resource
	private DateUtil dateUtil;

	/**
	 * 带状态查询车辆id和车辆编号
	 */
	@RequestMapping("getBicycle_infoByStatus.do")
	public List<Bicycle_info> getBicycle_infoByStatus(Integer status) {
		return instationService.getBicycle_infoByStatus(status);
	}

	/**
	 * 查询车辆站点信息
	 */
	@RequestMapping("getBicycle_stationList.do")
	public List<Bicycle_station> getBicycle_stationList() {
		return instationService.getBicycle_stationList();
	}

	/**
	 * 查询某车点的车桩信息
	 */
	@RequestMapping("getBicycle_pileListByStationId.do")
	public List<Bicycle_pile> getBicycle_pileListByStationId(Integer station_id) {
		return instationService.getBicycle_pileListByStationId(station_id, 2);
	}

	/**
	 * 车辆批量入桩
	 */
	@RequestMapping("instationByBatch.do")
	public String instationByBatch(@RequestBody List<Bicycle_pile> bicycle_pileList) {
		List<Bicycle_deploy> bicycle_deployList = getBicycle_deployListFromBicycle_pileList(bicycle_pileList);
		instationService.instationByBatch(bicycle_pileList, bicycle_deployList);
		return "success";
	}

	/**
	 * 由bicycle_pile集合获得bicycle_deploy
	 */
	@SuppressWarnings("static-access")
	private List<Bicycle_deploy> getBicycle_deployListFromBicycle_pileList(List<Bicycle_pile> list) {
		List<Bicycle_deploy> bicycle_deployList = new ArrayList<Bicycle_deploy>();
		for (Bicycle_pile pile : list) {
			Bicycle_deploy bd = new Bicycle_deploy();
			bd.setBicycle_id(Long.parseLong(pile.getBicycle_id()));
			bd.setTo_pile_id(pile.getPile_id());
			bd.setTo_reason(1);
			bd.setTo_time(dateUtil.getDateTime(new Date(System.currentTimeMillis())));
			bicycle_deployList.add(bd);
		}
		return bicycle_deployList;
	}
}
