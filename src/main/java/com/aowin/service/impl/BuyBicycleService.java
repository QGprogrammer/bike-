package com.aowin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.Bicycle_catagoryDao;
import com.aowin.dao.Bicycle_dealDao;
import com.aowin.dao.Bicycle_infoDao;
import com.aowin.dao.Bicycle_orderDao;
import com.aowin.dao.Bicycle_order_detailDao;
import com.aowin.dao.VenderDao;
import com.aowin.model.Bicycle_catagory;
import com.aowin.model.Bicycle_deal;
import com.aowin.model.Bicycle_info;
import com.aowin.model.Bicycle_order;
import com.aowin.model.Bicycle_order_detail;
import com.aowin.model.Vender;
import com.aowin.service.IBuyBicycleService;

/**
 * 购车的实现类
 * @author Peter
 *
 */
@Service
public class BuyBicycleService implements IBuyBicycleService {

	@Resource
	private VenderDao venderDao;
	@Resource
	private Bicycle_orderDao bicycle_orderDao;
	@Resource
	private Bicycle_infoDao bicycle_infoDao;
	@Resource
	private Bicycle_order_detailDao bicycle_order_detailDao;
	@Resource
	private Bicycle_dealDao bicycle_dealDao;
	@Resource
	private Bicycle_catagoryDao bicycle_catagoryDao;
	/**
	 * 获得供应商List
	 */
	public List<Vender> getVenderList() {
		return venderDao.getVenderList();
	}
	/**
	 * 新增采购主单
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void addBicycle_order(Bicycle_order bicycle_order, Bicycle_order_detail bicycle_order_detail, List<Bicycle_info> bicycle_infoList, Bicycle_deal bicycle_deal) {
		bicycle_orderDao.addBicycle_order(bicycle_order);
		bicycle_order_detail.setOrder_id(bicycle_order.getOrder_id()); //回填
		bicycle_infoDao.addBicycle_info(bicycle_infoList);
		bicycle_order_detail.setBicycle_infoList(bicycle_infoList);  //回填
		bicycle_deal.setBicycle_infoList(bicycle_infoList);  //回填
		bicycle_deal.setRecord_id(bicycle_order.getOrder_id());  //回填
		bicycle_dealDao.addBicycle_deal(bicycle_deal);
		bicycle_order_detailDao.addBicycle_order_detail(bicycle_order_detail);
	}
	/**
	 * 获得车辆信息中最大的车辆编号
	 */
	public String getMaxBicycleCode() {
		return bicycle_infoDao.getMaxBicycleCode();
	}
	/**
	 * 查询全部采购主单
	 */
	public List<Bicycle_order> getBicycle_orderList(){
		return bicycle_orderDao.getBicycle_orderList();
	}
	/**
	 * 查询某一采购主单的车辆编号List
	 */
	public List<Long> getBicycle_codeListByOrder_id(Long order_id){
		return bicycle_order_detailDao.getBicycle_codeListByOrder_id(order_id);
	}
	/**
	 * 查询车辆类型的全部信息List
	 */
	public List<Bicycle_catagory> getBicycle_catagoryList(){
		return bicycle_catagoryDao.getBicycle_catagoryList();
	}
	/**
	 * 更新（完善）明细单
	 */
	public int updateBicycle_order_detail(Bicycle_order_detail bicycle_order_detail) {
		return bicycle_order_detailDao.updateBicycle_order_detail(bicycle_order_detail);
	}

}
