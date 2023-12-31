package com.nagesh.spring.mydiary.UserBusiness;

import java.util.List;

import com.nagesh.spring.mydiary.entities.Entries;

public interface EntryBusinessInterFace {

	public void saveEntry(Entries entries);

	public Entries entryDetUpdate(Entries entries);
	public List<Entries> findByUserId(int id);

	public Entries getViewdetails(int id);
	public Entries deleteEntry(int id);

}
