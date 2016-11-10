package com.nixsolutions.spring.model.service;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Journal;

public interface JournalServ {
	public Journal save(Journal journal);
    public void update(Journal journal);
    public void delete(Journal journal);
    public void take(Journal journal);
    
    public ArrayList<Journal> findAll();
    public Journal findByID(Journal journal);
    public ArrayList<Journal> findByAdmin(Journal journal);
    public ArrayList<Journal> findByBook(Journal journal);
    public ArrayList<Journal> findByClient(Journal journal);
    public ArrayList<Journal> findOverdue();
    public ArrayList<Journal> findForTakeBook();
}
