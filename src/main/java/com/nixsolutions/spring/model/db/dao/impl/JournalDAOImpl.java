package com.nixsolutions.spring.model.db.dao.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nixsolutions.spring.model.db.dao.JournalDAO;
import com.nixsolutions.spring.model.db.entity.Journal;

import org.hibernate.Query;

@Repository
public class JournalDAOImpl implements JournalDAO {
	@Autowired
	SessionFactory sessionFactory;

    @Override
    public Journal createRecord(Journal journal) {
    	sessionFactory.getCurrentSession().save(journal);
		return journal;
    }

    @Override
    public void updateRecord(Journal journal) {
    	sessionFactory.getCurrentSession().update(journal);
    }

    @Override
    public void deleteRecord(Journal journal) {
    	sessionFactory.getCurrentSession().delete(journal);
    }

    @Override
    public ArrayList<Journal> findAllRecord() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Journal");
		ArrayList<Journal> listJournal = new ArrayList<>();
		listJournal.addAll(query.list());
		
		return listJournal;
    }
    
    @Override
    public Journal findRecordByID(Journal journal) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Journal j where j.recordID = :id").setLong("id", journal.getRecordID());
		journal = (Journal) query.list().get(0);
		
		return journal;
    }

    @Override
    public ArrayList<Journal> findRecordByAdmin(Journal journal) {
		ArrayList<Journal> listJournal = new ArrayList<>();
		Query query = sessionFactory.getCurrentSession().createQuery("from Journal j INNER JOIN j.admin admin "
		 		+ "where admin.adminID = :id").setLong("id", journal.getAdmin().getAdminID());
		listJournal.addAll(query.list());
		
		return listJournal;
    }

    @Override
    public ArrayList<Journal> findRecordByBook(Journal journal) {
		ArrayList<Journal> listJournal = new ArrayList<>();
		Query query = sessionFactory.getCurrentSession().createQuery("from Journal j INNER JOIN j.book book "
		 		+ "where book.bookID = :id").setLong("id", journal.getBook().getBookID());
		listJournal.addAll(query.list());
		
		return listJournal;
    }

    @Override
    public ArrayList<Journal> findRecordByClient(Journal journal) {
		ArrayList<Journal> listJournal = new ArrayList<>();
		Query query = sessionFactory.getCurrentSession().createQuery("from Journal j INNER JOIN j.client client "
		 		+ "where client.clientID = :id").setLong("id", journal.getClient().getClientID());
		listJournal.addAll(query.list());
		
		return listJournal;
    }

    @Override
    public ArrayList<Journal> findOverdueRecord() {
		ArrayList<Journal> listJournal = new ArrayList<>();
		Query query = sessionFactory.getCurrentSession().createQuery("from Journal j where j.dateFactReturn is null and"
				+ " j.dataReturn < current_timestamp()");
		listJournal.addAll(query.list());
		
		return listJournal;
    }

	@Override
	public ArrayList<Journal> findRecordForTakeBook() {
		ArrayList<Journal> listJournal = new ArrayList<>();
		Query query = sessionFactory.getCurrentSession().createQuery("from Journal j where j.dateFactReturn is null");
		listJournal.addAll(query.list());
		
		return listJournal;
	}

}
