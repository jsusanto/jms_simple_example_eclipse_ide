package com.linkedinjms.chapter1;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

// With @Component which will cause this class will be called in the application stary up
// It also allows other spring beans to find it.
@Component
public class Receiver {
	
	// The JmsListener will provide 2 parameters destination and factory
	// containerFactory should be used the name specified in the bean
	@JmsListener(destination = "order-queue", containerFactory = "warehouseFactory")
	public void receiveMessage(String message) {
		System.out.println("RECEIVED Message is : " + message);
	}
}
