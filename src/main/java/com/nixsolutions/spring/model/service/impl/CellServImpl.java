package com.nixsolutions.spring.model.service.impl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nixsolutions.spring.model.db.dao.BookDAO;
import com.nixsolutions.spring.model.db.dao.CellDAO;
import com.nixsolutions.spring.model.db.entity.Book;
import com.nixsolutions.spring.model.db.entity.Cell;
import com.nixsolutions.spring.model.service.CellServ;

@Service
@Transactional
public class CellServImpl implements CellServ{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	CellDAO cellDAO;
	@Autowired
	BookDAO bookDAO;
	
	@Override
	public Cell save(Cell cell) {
		if (!cell.getBook().getName().equals("null")) {
			Long bookID = Long.parseLong(cell.getBook().getName());
			cell.setBook(bookDAO.findRecordByID(new Book(bookID)));
		} else cell.setBook(null);
		return cellDAO.createRecord(cell);
	}
	
	@Override
	public void update(Cell cell) {
		Cell cellInDB = cellDAO.findRecordByID(cell);
		cellInDB.setCellNumber(cell.getCellNumber());
		if (!cell.getBook().getName().equals("null")) {
			Long bookID = Long.parseLong(cell.getBook().getName());
			cell.getBook().setBookID(bookID);
			if ((!cell.getBook().equals(cellInDB.getBook())))
				cellInDB.setBook(bookDAO.findRecordByID(cell.getBook()));	
		} else cellInDB.setBook(null);
		cellDAO.updateRecord(cellInDB);
	}
	
	@Override
	public void take(Cell cell) {
		cellDAO.updateRecord(cell);
	}
	
	@Override
	public void delete(Cell cell) {
		cellDAO.deleteRecord(cellDAO.findRecordByID(cell));
	}
	
	@Override
	public ArrayList<Cell> findAll() {
		return cellDAO.findAllRecord();
	}
	
	@Override
	public Cell findByID(Cell cell) {
		return cellDAO.findRecordByID(cell);
	}
	
	@Override
	public ArrayList<Cell> findByEmptyCell() {
		return cellDAO.findRecordByEmptyCell();
	}
	
	@Override
	public Cell findByBook(Cell cell) {
		return cellDAO.findRecordByBook(cell);
	}
}
