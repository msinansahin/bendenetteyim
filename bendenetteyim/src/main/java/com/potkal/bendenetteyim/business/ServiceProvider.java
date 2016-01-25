package com.potkal.bendenetteyim.business;

public class ServiceProvider {

	public static UserService getUserService () {
		return new UserServiceImpl();
	}
	
}
