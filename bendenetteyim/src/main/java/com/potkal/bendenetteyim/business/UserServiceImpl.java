package com.potkal.bendenetteyim.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.potkal.bendenetteyim.domain.User;

public class UserServiceImpl implements UserService {

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

}
