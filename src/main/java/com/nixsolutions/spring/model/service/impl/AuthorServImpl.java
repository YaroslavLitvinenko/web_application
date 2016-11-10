package com.nixsolutions.spring.model.service.impl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nixsolutions.spring.model.db.dao.AuthorDAO;
import com.nixsolutions.spring.model.db.entity.Author;
import com.nixsolutions.spring.model.service.AuthorServ;

@Service
@Transactional
public class AuthorServImpl implements AuthorServ {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	AuthorDAO authorDAO;

	@Override
	public Author save(Author author) {
		return authorDAO.createRecord(author);
	}

	@Override
	public void update(Author author) {
		authorDAO.updateRecord(author);
	}

	@Override
	public void delete(Author author) {
		authorDAO.deleteRecord(author);
		
	}

	@Override
	public ArrayList<Author> findAll() {
		return authorDAO.findAllRecord();
	}

	@Override
	public Author findByID(Author author) {
		return authorDAO.findRecordByID(author);
	}

	@Override
	public ArrayList<Author> findByNameSurname(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

}
