package com.aowin.listener;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
public class CodeListener implements MessageListener{
	
	
	@Override
	public void onMessage(Message message) {
		TextMessage codemsg = (TextMessage) message;
		try {
			System.out.println("您的短信验证码为："+ codemsg.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
