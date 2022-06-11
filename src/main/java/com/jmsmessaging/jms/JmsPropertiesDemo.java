package com.jmsmessaging.jms;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JmsPropertiesDemo {
	
		  
  @Autowired
  private JmsProperties jmsProperties;

  public static void main(String[] args) throws Exception {
	  
    SpringApplication.run(JmsPropertiesDemo.class, args);
  }
  
  @PostConstruct
  public void init() {
	  System.out.println("========================");
	  
	  if(jmsProperties.getSetReconnAttemptCount() > 0)
	      System.out.println("getSetReconnAttemptCount : " + jmsProperties.getSetReconnAttemptCount());
	  if(jmsProperties.getSetReconnAttemptDelay() > 0)
	      System.out.println("getSetReconnAttemptDelay : " + jmsProperties.getSetReconnAttemptDelay());
	  if(jmsProperties.getSetReconnAttemptTimeout() > 0)
  	      System.out.println("getSetReconnAttemptTimeout : " + jmsProperties.getSetReconnAttemptTimeout());
	  System.out.println("========================");
  }

}