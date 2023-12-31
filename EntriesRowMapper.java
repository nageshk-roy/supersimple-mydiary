package com.nagesh.spring.mydiary.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nagesh.spring.mydiary.entities.Entries;

public class EntriesRowMapper implements RowMapper<Entries> {

	@Override
	public Entries mapRow(ResultSet rs, int rowNum) throws SQLException {
		Entries entries=new Entries();
		entries.setDate(rs.getDate(2));
		entries.setUserid(rs.getInt(4));
		entries.setDescription(rs.getString(3));
		entries.setId(rs.getInt(1));
		return entries;
	}

}
