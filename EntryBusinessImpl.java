package com.nagesh.spring.mydiary.UserBusiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagesh.spring.mydiary.UserDao.EntryDaoInterface;
import com.nagesh.spring.mydiary.entities.Entries;

public class EntryBusinessImpl implements EntryBusinessInterFace {
@Autowired
	EntryDaoInterface entryDaoInterface;

	public EntryDaoInterface getEntryDaoInterface() {
		return entryDaoInterface;
	}

	public void setEntryDaoInterface(EntryDaoInterface entryDaoInterface) {
		this.entryDaoInterface = entryDaoInterface;
	}

	@Override
	public void saveEntry(Entries entries) {
		entryDaoInterface.saveEntry(entries);
	}

	public void getEntries(Entries entries) {

	}

	@Override
	public List<Entries> findByUserId(int id) {
		List<Entries> entries=entryDaoInterface.findByUserId(id);
		return entries;
	}

	@Override
	public Entries getViewdetails(int id) {
		Entries entries=entryDaoInterface.getViewdetails(id);
		return entries;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entries entryDetUpdate(Entries entries1) {
		Entries entries=entryDaoInterface.entryDetUpdate(entries1);
		return entries;
	}

	@Override
	public Entries deleteEntry(int id) {
		Entries entries=entryDaoInterface.deleteEntry(id);
		return entries;
	}

	

}
