package com.linkedinjms.chapter2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	//Because we made this Spring configuration under application.java class
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(String destination, String message) {
		jmsTemplate.convertAndSend(destination, message);
	}
}
