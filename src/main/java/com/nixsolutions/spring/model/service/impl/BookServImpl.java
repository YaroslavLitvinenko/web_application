package com.nixsolutions.spring.model.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nixsolutions.spring.model.db.dao.AuthorDAO;
import com.nixsolutions.spring.model.db.dao.BookDAO;
import com.nixsolutions.spring.model.db.dao.CategoryDAO;
import com.nixsolutions.spring.model.db.dao.CellDAO;
import com.nixsolutions.spring.model.db.entity.Author;
import com.nixsolutions.spring.model.db.entity.Book;
import com.nixsolutions.spring.model.db.entity.Category;
import com.nixsolutions.spring.model.db.entity.Cell;
import com.nixsolutions.spring.model.service.BookServ;

@Service
@Transactional
public class BookServImpl implements BookServ {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	BookDAO bookDAO;
	@Autowired
	CellDAO cellDAO;
	@Autowired
	AuthorDAO authorDAO;
	@Autowired
	CategoryDAO categoryDAO;
	
	@Override
	public Book save(Book book, String[] listAuthorsID, String cellID) {
		book.getCategory().setCategoryID(Long.parseLong(book.getCategory().getName()));
		book.setCategory(categoryDAO.findRecordByID(book.getCategory()));
		
		Set<Author> listAuthors = new HashSet<>();
		for(String authorID : listAuthorsID) {
			listAuthors.add(authorDAO.findRecordByID(new Author(Long.parseLong(authorID))));
		}
		book.setAuthors(listAuthors);
		
		bookDAO.createRecord(book);
		
		if (!cellID.equals("")) {
			Cell cell = new Cell(Long.parseLong(cellID));
			cell = cellDAO.findRecordByID(cell);
			cell.setBook(book);
			cellDAO.updateRecord(cell);
		}
		
		return book;
	}
	@Override
	public void update(Book book, String[] listAuthorsID, String cellID) {
		book.getCategory().setCategoryID(Long.parseLong(book.getCategory().getName()));
		book.setCategory(categoryDAO.findRecordByID(book.getCategory()));
		
		Set<Author> listAuthors = new HashSet<>();
		for(String authorID : listAuthorsID) {
			listAuthors.add(authorDAO.findRecordByID(new Author(Long.parseLong(authorID))));
		}
		book.setAuthors(listAuthors);
		
		try {
			bookDAO.updateRecord(book);
		} catch (NonUniqueObjectException e) {
		}
		
		if (cellID.equals("")) {
			Cell cell = new Cell(book);
			cell = cellDAO.findRecordByBook(cell);
			if (cell != null) {
				cell.setBook(null);
				cellDAO.updateRecord(cell);
			}
		} else {
			Long cellId = Long.parseLong(cellID);
			Cell cell = new Cell(book);
			cell = cellDAO.findRecordByBook(cell);
			if (cell != null) {
				if (cell.getCellID() != cellId) {
					cell.setBook(null);
					cellDAO.updateRecord(cell);
					
					cell = cellDAO.findRecordByID(new Cell(cellId));
					cell.setBook(book);
					cellDAO.updateRecord(cell);
				}
			} else {
				cell = cellDAO.findRecordByID(new Cell(cellId));
				cell.setBook(book);
				cellDAO.updateRecord(cell);
			}
		}
	}
	@Override
	public void delete(Book book) {
		Book bookFoDel = bookDAO.findRecordByID(book);
		Cell cell = cellDAO.findRecordByBook(new Cell(bookFoDel));
		cell.setBook(null);
		cellDAO.updateRecord(cell);
		bookDAO.deleteRecord(bookFoDel);
	}
	@Override
	public ArrayList<Book> findAll() {
		return bookDAO.findAllRecord();
	}
	@Override
	public ArrayList<Book> findByCategory(Book book) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Book findByID(Book book) {
		return bookDAO.findRecordByID(book);
		
	}
	@Override
	public ArrayList<Book> findByName(Book book) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Book> findForCell() {
		return bookDAO.findBookForCell();
	}
	@Override
	public ArrayList<Book> findAvailable() {
		return bookDAO.findAvailableBooks();
	}
}
