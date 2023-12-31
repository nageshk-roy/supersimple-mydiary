package com.nagesh.spring.mydiary.UserDao;

import com.nagesh.spring.mydiary.entities.User;

public interface UserdaoInterface {

	void insertUsers(User user);

	public User findByUserName(User user);

}
