package com.nixsolutions.spring.model.service;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Book;

public interface BookServ {
	public Book save(Book book, String[] listAuthorsID, String cellID);
    public void update(Book book, String[] listAuthorsID, String cellID);
    public void delete(Book book);
    
    public ArrayList<Book> findAll();
    public ArrayList<Book> findByCategory(Book book);
    public Book findByID(Book book);
    public ArrayList<Book> findByName(Book book);
    public ArrayList<Book> findForCell();
    public ArrayList<Book> findAvailable();
}
