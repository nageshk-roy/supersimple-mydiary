package com.nagesh.spring.mydiary.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nagesh.spring.mydiary.entities.User;



public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=new User();
		System.out.print("rs.getInt(1)==="+rs.getInt(1));
		user.setUserId(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setPaswwd(rs.getString(3));
		return user;
	}
	

}
