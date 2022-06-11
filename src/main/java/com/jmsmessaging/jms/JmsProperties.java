/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmsmessaging.jms;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author 606041
 */
@Configuration
@ConfigurationProperties(prefix = "tibcojmsprop")
@PropertySource("classpath:jms.properties")
public class JmsProperties {
	private int setReconnAttemptCount;
	private int setReconnAttemptDelay;
	private int setReconnAttemptTimeout;
        
    //Setters and Getters
    public int getSetReconnAttemptCount(){
        return setReconnAttemptCount;
    }
    
    public void setSetReconnAttemptCount(int setReconnAttemptCount){
        this.setReconnAttemptCount = setReconnAttemptCount;
    }
    
    public int getSetReconnAttemptDelay(){
        return setReconnAttemptDelay;
    }
    
    public void setSetReconnAttemptDelay(int setReconnAttemptDelay){
        this.setReconnAttemptDelay = setReconnAttemptDelay;
    }
            
    public int getSetReconnAttemptTimeout(){
        return setReconnAttemptTimeout;
    }
    
    public void setSetReconnAttemptTimeout(int setReconnAttemptTimeout){
        this.setReconnAttemptTimeout = setReconnAttemptTimeout;
    }

} 