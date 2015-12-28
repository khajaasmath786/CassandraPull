/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author v086714
 */
@Data
@Component
@Slf4j
public class ApplicationContextUtil implements ApplicationContextAware {
    public static ApplicationContext applicationContext;
    public static AnnotationConfigApplicationContext applicationAnnotationContext;
            
    @Override
    public void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }
    
    public static <T> T getBean(Class<T> type) {
    	if(applicationContext != null){
    		return applicationContext.getBean(type);
    	}
    	return applicationAnnotationContext.getBean(type);
    }
    
    public static Object getBean(String beanName) {
    	if(applicationContext != null){
    		return applicationContext.getBean(beanName);
    	}
    	return applicationAnnotationContext.getBean(beanName);
    }
}
