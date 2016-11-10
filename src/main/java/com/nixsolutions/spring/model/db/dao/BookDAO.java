package com.nixsolutions.spring.model.db.dao;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Book;


public interface BookDAO {
    public Book createRecord(Book book);
    public void updateRecord(Book book);
    public void deleteRecord(Book book);
    
    public ArrayList<Book> findAllRecord();
    public ArrayList<Book> findRecordByCategory(Book book);
    public Book findRecordByID(Book book);
    public ArrayList<Book> findRecordByName(Book book);
    public ArrayList<Book> findBookForCell();
    public ArrayList<Book> findAvailableBooks();
}
