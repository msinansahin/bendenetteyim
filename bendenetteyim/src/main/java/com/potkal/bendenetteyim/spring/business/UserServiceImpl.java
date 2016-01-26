package com.potkal.bendenetteyim.spring.business;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.potkal.bendenetteyim.domain.User;

@Service
public class UserServiceImpl implements UserService, InitializingBean {

	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User("admin", "admin"));
		users.add(new User("test", "test"));
	}
	
	
	@Override
	public boolean existsUser(String username, String password) {
		boolean result = false;
		for (User user : users) {
			result = StringUtils.equalsIgnoreCase(username, user.getUsername())
					&& StringUtils.equalsIgnoreCase(password, user.getPassword());
			if (result) {
				break;
			}
		}
		return result;
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		LOGGER.info(UserServiceImpl.class.getName() + " initialized");
	}

}
