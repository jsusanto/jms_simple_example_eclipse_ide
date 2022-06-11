package com.linkedinjms.chapter2;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

// By enabling jms annotation, we'll trigger the discovery of methods annotated
@EnableJms
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		Sender sender = context.getBean(Sender.class);
		sender.sendMessage("order-queue", "Hello World Chapter 2!");
	}
	
	//Because we're flagging this with @Bean annotation, it will make available to the Spring context
	@Bean
	public JmsListenerContainerFactory warehouseFactory(ConnectionFactory factory,
																	DefaultJmsListenerContainerFactoryConfigurer configurer){
		//Internal MQ by Spring-Boot
		DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
		configurer.configure(containerFactory, factory);
		return containerFactory;
	}
	
	//Connecting to Apache ActiveMQ
	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		//Instantiate
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
		return factory;
	}
	
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(connectionFactory());
	}
	
	//Add default JmsListenerContrainerFactory bean
	public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrency("1-1");
		return factory;
	}

}
