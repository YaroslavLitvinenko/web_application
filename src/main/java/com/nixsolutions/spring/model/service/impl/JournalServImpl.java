package com.nixsolutions.spring.model.service.impl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nixsolutions.spring.model.db.dao.AdminDAO;
import com.nixsolutions.spring.model.db.dao.BookDAO;
import com.nixsolutions.spring.model.db.dao.ClientDAO;
import com.nixsolutions.spring.model.db.dao.JournalDAO;
import com.nixsolutions.spring.model.db.dao.UserDAO;
import com.nixsolutions.spring.model.db.entity.Admin;
import com.nixsolutions.spring.model.db.entity.Book;
import com.nixsolutions.spring.model.db.entity.Client;
import com.nixsolutions.spring.model.db.entity.Journal;
import com.nixsolutions.spring.model.db.entity.User;
import com.nixsolutions.spring.model.service.JournalServ;

@Service
@Transactional
public class JournalServImpl implements JournalServ {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	JournalDAO journalDAO;
	@Autowired
	BookDAO bookDAO;
	@Autowired
	ClientDAO clientDAO;
	@Autowired
	AdminDAO adminDAO;
	@Autowired
	UserDAO userDAO;

	@Override
	public Journal save(Journal journal) {
		Book book = new Book(Long.parseLong(journal.getBook().getName()));
		Client client = new Client(Long.parseLong(journal.getClient().getFirstName()));
		
		org.springframework.security.core.userdetails.User userInSystem = 
				(org.springframework.security.core.userdetails.User)
				SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		User user = new User(userInSystem.getUsername());
		user = userDAO.findRecordByLogin(user);
		journal.setAdmin(adminDAO.findRecordByUserID(new Admin(user)));
		
		journal.setBook(bookDAO.findRecordByID(book));
		journal.setClient(clientDAO.findRecordByID(client));
		
		journalDAO.createRecord(journal);
		
		return journal;
	}

	@Override
	public void update(Journal journal) {
		Journal journalForUpdate = journalDAO.findRecordByID(journal);
		Book book = new Book(Long.parseLong(journal.getBook().getName()));
		journalForUpdate.setBook(bookDAO.findRecordByID(book));
		Client client = new Client(Long.parseLong(journal.getClient().getFirstName()));
		journalForUpdate.setClient(client);
		journalForUpdate.setDateIssue(journal.getDateIssue());
		journalForUpdate.setDateReturn(journal.getDateReturn());
		
		org.springframework.security.core.userdetails.User userInSystem = 
				(org.springframework.security.core.userdetails.User)
				SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		User user = new User(userInSystem.getUsername());
		user = userDAO.findRecordByLogin(user);
		journalForUpdate.setAdmin(adminDAO.findRecordByUserID(new Admin(user)));
		
		journalDAO.updateRecord(journalForUpdate);
	}

	@Override
	public void delete(Journal journal) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void take(Journal journal) {
		journalDAO.updateRecord(journal);
	}

	@Override
	public ArrayList<Journal> findAll() {
		return journalDAO.findAllRecord();
	}

	@Override
	public Journal findByID(Journal journal) {
		return journalDAO.findRecordByID(journal);
	}

	@Override
	public ArrayList<Journal> findByAdmin(Journal journal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Journal> findByBook(Journal journal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Journal> findByClient(Journal journal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Journal> findOverdue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Journal> findForTakeBook() {
		return journalDAO.findRecordForTakeBook();
	}

}
