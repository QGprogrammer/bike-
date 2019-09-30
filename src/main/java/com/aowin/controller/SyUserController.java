package com.aowin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.aowin.model.SyRole;
import com.aowin.model.SyUser;
import com.aowin.service.ISyRoleService;
import com.aowin.service.ISyUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 用户管理控制层
 * 
 * @author Peter
 *
 */
@RequestMapping("syuser")
@Controller
public class SyUserController {

	@Resource
	private ISyUserService syUserService;
	@Resource
	private ISyRoleService syRoleService;

	/**
	 * 模糊查询用户信息
	 */
	@ResponseBody
	@RequestMapping(value = "getSyUserList.do", produces = "text/json;charset=utf-8")
	public String getSyUserList(@RequestBody SyUser syUser) {
		// 未选择
		if (syUser.getRole_id() == -1) {
			syUser.setRole_id(null);
		}
		if (syUser.getZxbj() == -1) {
			syUser.setZxbj(null);
		}
		// 分页
		int pageSize = 5; // 每页的记录数特殊***
		PageHelper.startPage(syUser.getPageNum(), pageSize);
		// 数据库查询
		List<SyUser> list = syUserService.getSyUserList(syUser);
		PageInfo<SyUser> info = new PageInfo<SyUser>(list);
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
	 * 获取角色List（用户角色查询）
	 */
	@ResponseBody
	@RequestMapping(value = "getSyRoleList.do", produces = "text/json;charset=utf-8")
	public String getSyRoleList() {
		List<SyRole> list = syRoleService.getSyRoleList(new SyRole());
		return JSONArray.toJSONString(list);
	}

	/**
	 * 新增用户
	 */
	@ResponseBody
	@RequestMapping("addSyUser.do")
	public String addSyUser(@RequestBody SyUser syUser) {
		if (syUser.getRole_id() == -1) {
			syUser.setRole_id(null);
		}
		int flag = syUserService.addSyUser(syUser);
		if (flag == 1) {
			return "success";
		}
		return "failure";
	}

	/**
	 * 用户登录名校验
	 */
	@ResponseBody
	@RequestMapping("checkLogin_name.do")
	public String checkLogin_name(String login_name) {
		SyUser syUser = syUserService.checkLogin_name(login_name);
		if (syUser != null) {
			return "existed";
		}
		return "success";
	}

	/**
	 * 注销用户
	 */
	@ResponseBody
	@RequestMapping("cancelSyUser.do")
	public String cancelSyUser(Integer user_id) {
		int flag = syUserService.cancelSyUser(user_id);
		if (flag == 1) {
			return "success";
		}
		return "failure";
	}

	/**
	 * 获取用户的信息
	 */
	@ResponseBody
	@RequestMapping("getSyUser.do")
	public SyUser getSyUser(Integer user_id) {
		return syUserService.getSyUser(user_id);
	}

	/**
	 * 修改用户信息
	 */
	@ResponseBody
	@RequestMapping("updateSyUser.do")
	public String updateSyUser(@RequestBody SyUser syUser) {
		if (syUser.getRole_id() == -1) {
			syUser.setRole_id(null);
		}
		int flag = syUserService.updateSyUser(syUser);
		if (flag == 1) {
			return "success";
		}
		return "failure";
	}
}
