package com.nagesh.spring.mydiary.UserBusiness;

import com.nagesh.spring.mydiary.entities.User;

public interface UserBusinessInterface {

	
	void insertUsers(User user);
	public  User findByUserName(User user);
	
}
