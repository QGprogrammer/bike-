package com.aowin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.aowin.model.MsPhase;
import com.aowin.model.SyUser;
import com.aowin.service.IMsPhaseService;
import com.aowin.service.ISyRoleService;
import com.aowin.service.ISyUserService;
import com.aowin.service.impl.JmsService;
import com.aowin.util.ImageUtil;

/**
 * 登录登出的控制层
 * 
 * @author Peter
 *
 */
@RequestMapping("loginAndOut")
@Controller
public class LoginAndLogoutController {

	@Resource
	private ISyUserService syUserService;
	@Resource
	private ISyRoleService syRoleService;
	@SuppressWarnings("rawtypes")
	@Resource
	private RedisTemplate redisTemplate;
	@Resource
	private JmsTemplate jmsTemplate;
	@Resource
	private JmsService jmsService;
	@Resource
	private ImageUtil imageUtil;
	@Resource
	private IMsPhaseService msPhaseService;

	/**
	 * 用户登录校验
	 */
	@ResponseBody
	@RequestMapping(value = "checkSyUser.do", produces = "application/json;charset=utf-8")
	public String checkSyUser(HttpSession session, HttpServletRequest request) {
		// 验证码校验
		String verify = request.getParameter("verify");
		String code = (String) redisTemplate.opsForValue().get("code");
		if (code == null) {
			return "noverify";
		} else if (!verify.equals(code)) {
			return "errorverify";
		} else {
			// 账号校验
			SyUser syUser = new SyUser();
			syUser.setLogin_name(request.getParameter("login_name"));
			syUser.setPassword(request.getParameter("password"));
			syUser = syUserService.checkSyUser(syUser);
			if (syUser != null) {
				List<MsPhase> msPhaseList = syRoleService.getRoleSyPermission(syUser.getRole_id()).getMsPhaseList(); // 查询用户的授权
				session.setAttribute("syUser", syUser); // 存进作用域
				session.setAttribute("msPhaseList", getUrlList(msPhaseList)); // 存进作用域
				return JSON.toJSONString(syUser);
			}
		}
		return "error";
	}

	/**
	 * 用戶退出登录
	 */
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("syUser");
		return "redirect:/index.html";
	}

	/**
	 * 验证码服务
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping("verifyCode.do")
	public String verifyCode() throws IOException {
		String code = "" + (new Random().nextInt(1000) + 1002);
		// jmsService.sendCode(code); //发送至jms中
		redisTemplate.opsForValue().set("code", code, 10, TimeUnit.SECONDS);
		return imageUtil.getImageBase64(code);
	}

	/**
	 * 手机验证码服务
	 */
	@ResponseBody
	@RequestMapping("verifyPhoneCode.do")
	public String verifyPhoneCode(String phone) throws IOException {
		String code = "" + (new Random().nextInt(1000) + 1002);
		jmsService.sendCode(code); // 发送至jms中
		return "success";
	}

	/**
	 * 获取全部权限信息
	 */
	@ResponseBody
	@RequestMapping("getAllMsPhase.do")
	public String getAllMsPhase(HttpSession session) {
		session.setAttribute("allMsPhase", getUrlList(msPhaseService.getMsPhaseList(new MsPhase())));
		return "success";
	}

	/**
	 * 提取msPhaseList的url至hashset
	 */
	private List<String> getUrlList(List<MsPhase> list) {
		List<String> li = new ArrayList<String>();
		for (MsPhase msPhase : list) {
			li.add(msPhase.getUrl());
		}
		return li;
	}
}
