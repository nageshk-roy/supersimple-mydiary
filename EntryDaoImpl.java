package com.nagesh.spring.mydiary.UserDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nagesh.spring.mydiary.entities.Entries;
import com.nagesh.spring.mydiary.rowMapper.EntriesRowMapper;

public class EntryDaoImpl implements EntryDaoInterface {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveEntry(Entries entries) {
		String sql = "insert into entryies values(?,?,?,?)";
		String sql1="select ENTRY_ID_SEQ.nextval from dual";
		int seq = jdbcTemplate.queryForInt(sql1);
		jdbcTemplate.update(sql, seq + "", entries.getDate(),entries.getDescription() , entries.getUserid() + "");
		
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void getEntries(Entries entries) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Entries> findByUserId(int id) {
		String sql = "SELECT * FROM entryies where USER_ID=?";
		EntriesRowMapper entriesRowMapper = new EntriesRowMapper();
		List<Entries> entries=jdbcTemplate.query(sql, new Object[] { id }, entriesRowMapper);
		return  entries;
	}

	@Override
	public Entries getViewdetails(int id) {
		String sql = "SELECT * FROM entryies where ID=?";
		EntriesRowMapper entriesRowMapper = new EntriesRowMapper();
		Entries entries= jdbcTemplate.queryForObject(sql, new Object[] { id }, entriesRowMapper);
		return  entries;
	}

	@Override
	public Entries entryDetUpdate(Entries entries) {
		String sql ="UPDATE entryies  set description=? where ID=? ";
		jdbcTemplate.update(sql,entries.getDescription(), entries.getId());
		return null;
	}

	@Override
	public Entries deleteEntry(int id) {
		String sql ="DELETE FROM  entryies  where ID=? ";
		jdbcTemplate.update(sql, id);
		return null;
		
	}

}
