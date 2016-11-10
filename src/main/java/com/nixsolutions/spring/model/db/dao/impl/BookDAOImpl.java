package com.nixsolutions.spring.model.db.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nixsolutions.spring.model.db.dao.BookDAO;
import com.nixsolutions.spring.model.db.entity.Book;

import org.hibernate.Query;


@Repository
@Transactional
public class BookDAOImpl implements BookDAO {
	@Autowired
	SessionFactory sessionFactory;

    @Override
    public Book createRecord(Book book) {
    	sessionFactory.getCurrentSession().save(book);
		return book;
    }

    @Override
    public void updateRecord(Book book) {
    	sessionFactory.getCurrentSession().update(book);
    }

    @Override
    public void deleteRecord(Book book) {
    	sessionFactory.getCurrentSession().delete(book);
    }

    @Override
    public ArrayList<Book> findAllRecord() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Book");
		ArrayList<Book> listBook = new ArrayList<>();
		listBook.addAll(query.list());
		
		return listBook;
    }

    @Override
    public ArrayList<Book> findRecordByCategory(Book book) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Book b where b.category.categoryID = :id").setLong("id", book.getCategory().getCategoryID());
		ArrayList<Book> listBook = new ArrayList<>();
		listBook.addAll(query.list());
		
		return listBook;
    }

    @Override
    public Book findRecordByID(Book book) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Book b where b.bookID = :id").setLong("id", book.getBookID());
		book = (Book) query.list().get(0);
		
		return book;
    }

    @Override
    public ArrayList<Book> findRecordByName(Book book) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Book b where b.name = :name").setString("name", book.getName());
		ArrayList<Book> listBook = new ArrayList<>();
		listBook.addAll(query.list());
		
		return listBook;
    }

	@Override
	public ArrayList<Book> findBookForCell() {
		Session session = sessionFactory.getCurrentSession();
		
		ArrayList<Book> listBook = new ArrayList<>();
		
		Query query = session.createQuery("select c.book.bookID from Cell c where c.book is not null");
		List<Long> listBookIdInCell = query.list();
		
		query = session.createQuery("select j.book.bookID from Journal j where j.book is not null");
		List<Long> listBookIdInJournal = query.list();
		
		query = session.createQuery("select b from Book b where b.bookID not in :cell and b.bookID not in :journal")
				.setParameterList("cell", listBookIdInCell).setParameterList("journal", listBookIdInJournal);
		
		listBook.addAll(query.list());
		
		return listBook;
	}
	
	@Override
	public ArrayList<Book> findAvailableBooks() {
		Session session = sessionFactory.getCurrentSession();
		
		ArrayList<Book> listBook = new ArrayList<>();
		
		Query query = session.createQuery("select j.book.bookID from Journal j where j.book is not null");
		List<Long> listBookIdInJournal = query.list();
		
		query = session.createQuery("from Book b where b.bookID not in :journal").setParameterList("journal", listBookIdInJournal);
		listBook.addAll(query.list());
		
		return listBook;
	}
    
}
