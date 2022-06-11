package com.linkedinjms.chapter2;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

// With @Component which will cause this class will be called in the application stary up
// It also allows other spring beans to find it.
@Component
public class Receiver {
	//Remove the connection factory because it's been configuration using the new spring configuration
	//back on the Application.java file.
	@JmsListener(destination = "order-queue")
	public void receiveMessage(String message) {
		System.out.println("RECEIVED Message is : " + message);
	}
}
