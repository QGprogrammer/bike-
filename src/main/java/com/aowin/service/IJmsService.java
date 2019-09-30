package com.aowin.service;

/**
 * jms的服务接口
 * @author Peter
 *
 */
public interface IJmsService {

	/**
	 * 发送验证码
	 */
	void sendCode(String code);
}
