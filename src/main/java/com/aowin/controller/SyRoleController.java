package com.aowin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.aowin.model.SyRole;
import com.aowin.service.ISyPermissionService;
import com.aowin.service.ISyRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 角色控制器
 * 
 * @author Peter
 *
 */
@RequestMapping("role")
@Controller
public class SyRoleController {
	@Resource
	private ISyRoleService syRoleService;
	@Resource
	private ISyPermissionService syPermissionService;

	/**
	 * 查询所有角色信息
	 */
	@ResponseBody
	@RequestMapping(value="getSyRoleList.do",produces = "text/json;charset=utf-8")
	public String getSyRoleList(HttpServletRequest request) {
		// 接收数据
		String role_name = request.getParameter("role_name");
		String role_describe = request.getParameter("role_describe");
		Integer pageNum = Integer.parseInt(request.getParameter("pageNum") == null ? "0" : request.getParameter("pageNum"));
		// 封装对象
		SyRole syRole = new SyRole();
		syRole.setRole_name(role_name);
		syRole.setRole_describe(role_describe);
		// 分页
		int pageSize = 20; // 每页的记录数特殊***
		PageHelper.startPage(pageNum, pageSize);
		List<SyRole> list = syRoleService.getSyRoleList(syRole);
		PageInfo<SyRole> info = new PageInfo<SyRole>(list);
		// send
		if (list.size() > 0) {
			String result = JSONArray.toJSONString(list);
			result = result.substring(0, result.length() - 1);
			result += (",{\"navigatepageNums\":" + info.getPages() + ",\"total\":" + list.size() + ",\"pageSize\":"
					+ list.size() + "}]");
			return result;
		}
		return "{\"flag\":\"nothing\"}";
	}
	/**
	 * 查询某个角色的全部信息
	 */
	@ResponseBody
	@RequestMapping("getSyRole.do")
	public SyRole getSyRole(Integer role_id) {
		return syRoleService.getSyRole(role_id);
	}
	/**
	 * 修改角色的权限信息
	 */
	@ResponseBody
	@RequestMapping("updateSyRole.do")
	public String updateSyRole(@RequestBody SyRole syRole) {
		syRoleService.updateMsPhaseOfRole(syRole);	
		return "success";
	}
	/**
	 * 新增角色
	 */
	@ResponseBody
	@RequestMapping("addSyRole.do")
	public String addSyRole(@RequestBody SyRole syRole) {
		SyRole cs = syRoleService.checkSyRole(syRole.getRole_name());
		if (cs == null) {
			syRoleService.addSyRole(syRole);	
			return "success";
		}else {
			return "existed";
		}
	}
	/**
	 * 删除角色
	 */
	@ResponseBody
	@RequestMapping("deleteSyRole.do")
	public String deleteSyRole(Integer role_id) {
		Integer flag = syRoleService.getRoleCountBySyUser(role_id);
		if (flag != 1) {
			syRoleService.deleteSyRole(role_id);
			return "success";			
		}
		return "failure";
	}
	
}
