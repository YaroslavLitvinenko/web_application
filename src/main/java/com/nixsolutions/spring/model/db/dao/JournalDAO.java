package com.nixsolutions.spring.model.db.dao;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Journal;


public interface JournalDAO {
    public Journal createRecord(Journal journal);
    public void updateRecord(Journal journal);
    public void deleteRecord(Journal journal);
    
    public ArrayList<Journal> findAllRecord();
    public Journal findRecordByID(Journal journal);
    public ArrayList<Journal> findRecordByAdmin(Journal journal);
    public ArrayList<Journal> findRecordByBook(Journal journal);
    public ArrayList<Journal> findRecordByClient(Journal journal);
    public ArrayList<Journal> findOverdueRecord();
    public ArrayList<Journal> findRecordForTakeBook();
}
