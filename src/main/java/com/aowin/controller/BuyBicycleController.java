package com.aowin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.model.Bicycle_catagory;
import com.aowin.model.Bicycle_deal;
import com.aowin.model.Bicycle_info;
import com.aowin.model.Bicycle_order;
import com.aowin.model.Bicycle_order_detail;
import com.aowin.model.SyUser;
import com.aowin.model.Vender;
import com.aowin.service.IBuyBicycleService;
import com.aowin.util.CodeUtil;
import com.aowin.util.DateUtil;

/**
 * 新车购入的控制器
 * 
 * @author Peter
 *
 */
@RestController
@RequestMapping("buy")
public class BuyBicycleController {
	@Resource
	private IBuyBicycleService buyBicycleService;
	@Resource
	private DateUtil dateUtil;
	@Resource
	private CodeUtil codeUtil;

	/**
	 * 获取供应商的List
	 */
	@RequestMapping("getVenderList.do")
	public List<Vender> getVenderList() {
		return buyBicycleService.getVenderList();
	}

	/**
	 * 新增采购主单
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("addBicycle_order.do")
	public String addBicycle_order(@RequestBody Bicycle_order bicycle_order, HttpSession session) {
		// 主单
		Date now = new Date(System.currentTimeMillis());
		SyUser syUser = (SyUser) session.getAttribute("syUser");
		if (syUser == null) {
			return "failure";
		}
		bicycle_order.setOperator_time(dateUtil.getDateTime(now));
		// bicycle_order.setBuy_date(dateUtil.getDate(now)); // 前台还没处理好 先用这个
		bicycle_order.setOrder_code(codeUtil.getBicycle_orderCode(now));
		bicycle_order.setUser_id(syUser.getUser_id());
		// 明细单
		Bicycle_order_detail bicycle_order_detail = new Bicycle_order_detail();
		List<Bicycle_info> bicycle_infoList = getBicycle_infoList(bicycle_order);
		bicycle_order_detail.setCreate_date(dateUtil.getDate(now));
		// 流水
		Bicycle_deal bicycle_deal = new Bicycle_deal();
		bicycle_deal.setChg_money(bicycle_order.getBuy_price());
		bicycle_deal.setCreate_time(bicycle_order.getOperator_time());
		bicycle_deal.setDeal_name("新车购入");
		bicycle_deal.setDeal_type(1);
		bicycle_deal.setIs_fee(1);
		bicycle_deal.setFee_type(2);
		bicycle_deal.setUser_id(syUser.getUser_id());

		buyBicycleService.addBicycle_order(bicycle_order, bicycle_order_detail, bicycle_infoList, bicycle_deal);

		return "success";
	}

	/**
	 * 根据主单数量生成bicycle_infoList
	 */
	private List<Bicycle_info> getBicycle_infoList(Bicycle_order bicycle_order) {
		Long maxCode = Long.valueOf(buyBicycleService.getMaxBicycleCode());
		if (maxCode == 0) {
			maxCode = 10000000l;
		}
		List<Bicycle_info> list = new ArrayList<Bicycle_info>();
		for (int i = 0; i < bicycle_order.getBuy_num(); i++) {
			Bicycle_info bicycle_info = new Bicycle_info();
			bicycle_info.setBicycle_code(String.valueOf(maxCode += 1));
			bicycle_info.setStatus(1); // 购入未入桩
			bicycle_info.setUser_id(bicycle_order.getUser_id());
			bicycle_info.setOperator_time(bicycle_order.getOperator_time());
			;
			list.add(bicycle_info);
		}
		return list;
	}

	/**
	 * 查询全部采购主单
	 */
	@RequestMapping("getBicycle_orderList.do")
	public List<Bicycle_order> getBicycle_orderList() {

		return buyBicycleService.getBicycle_orderList();
	}

	/**
	 * 查询某一采购主单的车辆编号List
	 */
	@RequestMapping("getBicycle_codeListByOrder_id.do")
	public List<Long> getBicycle_codeListByOrder_id(Long order_id) {
		return buyBicycleService.getBicycle_codeListByOrder_id(order_id);
	}

	/**
	 * 查询车辆类型的全部信息List
	 */
	@RequestMapping("getBicycle_catagoryList.do")
	public List<Bicycle_catagory> getBicycle_catagoryList() {
		return buyBicycleService.getBicycle_catagoryList();
	}

	/**
	 * 明细单更新（新增）
	 */
	/**
	 * 更新（完善）明细单
	 */
	@RequestMapping("updateBicycle_order_detail.do")
	public String updateBicycle_order_detail(@RequestBody Bicycle_order_detail bicycle_order_detail) {
		buyBicycleService.updateBicycle_order_detail(bicycle_order_detail);
		return "success";
	}
}
