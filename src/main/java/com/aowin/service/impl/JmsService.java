package com.aowin.service.impl;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.aowin.service.IJmsService;

/**
 * jms服务的实现类
 * @author Peter
 *
 */
@Service
public class JmsService implements IJmsService {
	@Resource
	private JmsTemplate jmsTemplate;
	@Resource
	private Queue queue;
	@SuppressWarnings("rawtypes")
	@Resource
	private RedisTemplate redisTemplate;
	/**
	 * 发送验证码
	 */
	public void sendCode(String code) {
		//发送消息至队列
		jmsTemplate.send(queue, new MessageCreator() {
			
			@SuppressWarnings("unchecked")
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage(code);
				redisTemplate.opsForValue().set("phonecode", code, 10, TimeUnit.SECONDS);
				return msg;
			}
		});
	}
}
