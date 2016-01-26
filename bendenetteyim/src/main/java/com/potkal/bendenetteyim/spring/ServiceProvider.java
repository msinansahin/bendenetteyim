package com.potkal.bendenetteyim.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.potkal.bendenetteyim.spring.business.UserService;

public class ServiceProvider implements ApplicationContextAware {

	private static ApplicationContext context;
	
	public static UserService getUserService () {
		return context.getBean(UserService.class);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
	
}
