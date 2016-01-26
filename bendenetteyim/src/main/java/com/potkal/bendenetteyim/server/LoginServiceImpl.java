package com.potkal.bendenetteyim.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.potkal.bendenetteyim.client.service.LoginService;
import com.potkal.bendenetteyim.spring.ServiceProvider;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	@Override
	public Boolean existsUser(String username, String password) throws IllegalArgumentException {
		return ServiceProvider.getUserService().existsUser(username, password);
	}

}
