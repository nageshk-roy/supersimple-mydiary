package com.nagesh.spring.mydiary.UserBusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagesh.spring.mydiary.UserDao.UserdaoInterface;
import com.nagesh.spring.mydiary.entities.User;
@Component
public class UserBusinessImpl implements UserBusinessInterface {
	@Autowired
UserdaoInterface userDaoInterface;
	public UserdaoInterface getUserDaoInterface() {
	return userDaoInterface;
}
public void setUserDaoInterface(UserdaoInterface userDaoInterface) {
	this.userDaoInterface = userDaoInterface;
}
	@Override
	public void insertUsers(User user) {
		userDaoInterface.insertUsers(user);
		
	}
	@Override
	public User findByUserName(User user) {
		User passwd=userDaoInterface.findByUserName(user);
		return passwd;	
		
	}

}
