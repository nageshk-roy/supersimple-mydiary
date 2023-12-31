package com.nagesh.spring.mydiary.UserDao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.nagesh.spring.mydiary.entities.User;
import com.nagesh.spring.mydiary.rowMapper.UserRowMapper;
@Component
public class UserdaoImpl implements UserdaoInterface {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertUsers(User user) {
		String sql = "insert into USERS values(?,?,?,?)";
		String sql1 = "select sequence_1.nextval from dual";
		int seq = jdbcTemplate.queryForInt(sql1);
		jdbcTemplate.update(sql, seq + "", user.getUsername(), user.getPaswwd(), seq + "");

	}

	@Override
	public User findByUserName(User user) {
		String sql = "SELECT * FROM USERS where USER_NAME=?";
		UserRowMapper UserRowMapper = new UserRowMapper();
		User user1 = jdbcTemplate.queryForObject(sql, new Object[] { user.getUsername() }, UserRowMapper);
		return user1;
	}
}
