package com.nixsolutions.spring.model.service.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nixsolutions.spring.model.db.dao.BookDAO;
import com.nixsolutions.spring.model.db.dao.CategoryDAO;
import com.nixsolutions.spring.model.db.dao.CellDAO;
import com.nixsolutions.spring.model.db.entity.Book;
import com.nixsolutions.spring.model.db.entity.Category;
import com.nixsolutions.spring.model.db.entity.Cell;
import com.nixsolutions.spring.model.service.CategoryServ;

@Service
@Transactional
public class CategoryServImpl implements CategoryServ {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private BookDAO bookDAO;
	@Autowired
	private CellDAO cellDAO;

	@Override
	public Category save(Category category) {
		return categoryDAO.createRecord(category);
	}

	@Override
	public void update(Category category) {
		categoryDAO.updateRecord(category);;
	}

	@Override
	public void delete(Category category) {
		Category c = categoryDAO.findRecordByID(category);
		ArrayList<Book> listBookForDelete = bookDAO.findRecordByCategory(new Book(c));
		for (Book book : listBookForDelete) {
			Cell cell = cellDAO.findRecordByBook(new Cell(book));
			cell.setBook(null);
			cellDAO.updateRecord(cell);
			bookDAO.deleteRecord(book);
		}
		categoryDAO.deleteRecord(c);
	}

	@Override
	public ArrayList<Category> findAll() {
		return categoryDAO.findAllRecord();
	}

	@Override
	public Category findByID(Category category) {
		return categoryDAO.findRecordByID(category);
	}

	@Override
	public Category findByName(Category category) {
		return categoryDAO.findRecordByName(category);
	}

}
