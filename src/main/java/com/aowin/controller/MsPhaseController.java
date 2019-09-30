package com.aowin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.aowin.model.MsPhase;
import com.aowin.service.IMsPhaseService;
import com.aowin.service.ISyPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 用户权限相关得控制器
 * 
 * @author Peter
 *
 */
@RequestMapping("msphase")
@Controller
public class MsPhaseController {
	@Resource
	private IMsPhaseService msPhaseService;
	@Resource
	private ISyPermissionService syPermissionService;

	/**
	 * 模糊查询获得用户权限List
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getMsPhaseList.do", produces = "text/json;charset=utf-8")
	public String getMsPhaseList(HttpServletRequest request) {
		// 接收数据
		String url = request.getParameter("url");
		String description = request.getParameter("description");
		Integer pageNum = Integer
				.parseInt(request.getParameter("pageNum") == null ? "0" : request.getParameter("pageNum"));
		// 封装对象
		MsPhase msPhase = new MsPhase();
		msPhase.setUrl(url);
		msPhase.setDescription(description);
		// 分页
		int pageSize = 4; // 每页的记录数
		PageHelper.startPage(pageNum, pageSize);
		List<MsPhase> list = msPhaseService.getMsPhaseList(msPhase);
		PageInfo<MsPhase> info = new PageInfo<MsPhase>(list);
		// send
		if (list.size() > 0) {
			String result = JSONArray.toJSONString(list);
			result = result.substring(0, result.length() - 1);
			result += (",{\"navigatepageNums\":" + info.getPages() + ",\"total\":" + info.getTotal() + ",\"pageSize\":"
					+ pageSize + "}]");
			return result;
		}
		return "{\"flag\":\"nothing\"}";
	}

	/**
	 * 新增权限
	 */
	@ResponseBody
	@RequestMapping("addMsPhase.do")
	public String addMsPhase(MsPhase msPhase) {
		MsPhase am = msPhaseService.checkMsPhase(msPhase.getUrl());
		if (am == null) {
			msPhaseService.addMsPhase(msPhase);
			return "success";
		}
		return "failure";
	}

	/**
	 * 删除权限
	 */
	@ResponseBody
	@RequestMapping("deleteMsPhase.do")
	public String deleteMsPhase(Integer phaseid) {
		Integer count = syPermissionService.getMsPhaseCount(phaseid);
		if (count == 0) {
			Integer flag = msPhaseService.deleteMsPhase(phaseid);
			if (flag == 1) {
				return "success";
			}
		}
		return "failure";
	}

	/**
	 * 查询某权限信息
	 */
	@ResponseBody
	@RequestMapping("getMsPhase.do")
	public MsPhase getMsPhase(Integer phaseid) {
		MsPhase msPhase = msPhaseService.getMsPhase(phaseid);
		return msPhase;
	}

	/**
	 * 更改权限信息
	 */
	@ResponseBody
	@RequestMapping("updateMsPhase.do")
	public String updateMsPhase(MsPhase msPhase) {
		int flag = msPhaseService.updateMsPhase(msPhase);
		if (flag == 1) {
			return "success";
		}
		return "failure";
	}

	/**
	 * 查询全部权限信息
	 */
	@ResponseBody
	@RequestMapping(value = "getAllMsPhaseList.do", produces = "text/json;charset=utf-8")
	public String getAllMsPhaseList() {
		return JSONArray.toJSONString(msPhaseService.getMsPhaseList(new MsPhase()));
	}

}
