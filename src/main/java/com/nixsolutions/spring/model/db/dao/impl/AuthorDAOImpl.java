package com.nixsolutions.spring.model.db.dao.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nixsolutions.spring.model.db.dao.AuthorDAO;
import com.nixsolutions.spring.model.db.entity.Author;

import org.hibernate.Criteria;
import org.hibernate.Query;


@Repository
public class AuthorDAOImpl implements AuthorDAO{
	@Autowired
	SessionFactory sessionFactory;
	
    @Override
    public Author createRecord(Author author) {
    	sessionFactory.getCurrentSession().save(author);
		return author;
    }

    @Override
    public void updateRecord(Author author) {
    	sessionFactory.getCurrentSession().update(author);
    }

    @Override
    public void deleteRecord(Author author) {
    	sessionFactory.getCurrentSession().delete(author);
    }

    @Override
    public ArrayList<Author> findAllRecord() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Author");
		ArrayList<Author> listAuthor = new ArrayList<>();
		listAuthor.addAll(query.list());
		
		return listAuthor;
    }

    @Override
    public Author findRecordByID(Author author) {
    	if (author.getAuthorID() == null)
    		return null;
		Query query = sessionFactory.getCurrentSession().createQuery("from Author a where a.authorID = :id").setLong("id", author.getAuthorID());
		author = (Author) query.list().get(0);
		
		return author;
    }

    @Override
    public ArrayList<Author> findRecordByNameSurname(Author author) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Author.class);
		c.add(Restrictions.eq("firstName", author.getFirstName()));
		c.add(Restrictions.eq("lastName", author.getLastName()));
		c.add(Restrictions.eq("middleName", author.getMiddleName()));
		
		ArrayList<Author> listAuthor = new ArrayList<>();
		listAuthor.addAll(c.list());
		
		return listAuthor;
    }

}
