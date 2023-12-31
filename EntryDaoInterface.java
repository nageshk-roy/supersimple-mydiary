package com.nagesh.spring.mydiary.UserDao;

import java.util.List;

import com.nagesh.spring.mydiary.entities.Entries;

public interface EntryDaoInterface {
	
	public void saveEntry(Entries entries);
	public void getEntries(Entries entries);
	public List<Entries> findByUserId(int id);
	public Entries getViewdetails(int id);
	public Entries deleteEntry(int id);
	public Entries  entryDetUpdate(Entries entries);

}
