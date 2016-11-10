package com.nixsolutions.spring.model.db.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nixsolutions.spring.model.db.dao.CellDAO;
import com.nixsolutions.spring.model.db.entity.Cell;

import org.hibernate.Query;


@Repository
public class CellDAOImpl implements CellDAO {
	@Autowired
	SessionFactory sessionFactory;

    @Override
    public Cell createRecord(Cell cell) {
    	sessionFactory.getCurrentSession().save(cell);
		return cell;
    }

    @Override
    public void updateRecord(Cell cell) {
    	sessionFactory.getCurrentSession().update(cell);
    }

    @Override
    public void deleteRecord(Cell cell) {
    	sessionFactory.getCurrentSession().delete(cell);
    }

    @Override
    public ArrayList<Cell> findAllRecord() {
    	Query query = sessionFactory.getCurrentSession().createQuery("from Cell");
		ArrayList<Cell> listCell = new ArrayList<>();
		listCell.addAll(query.list());
		
		return listCell;
    }
    
    @Override
    public Cell findRecordByID(Cell cell) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Cell c where c.cellID = :id").setLong("id", cell.getCellID());
		cell = (Cell) query.list().get(0);
		
		return cell;
    }

    @Override
    public ArrayList<Cell> findRecordByEmptyCell() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Cell c where c.book is null");
		ArrayList<Cell> listCell = new ArrayList<>();
		listCell.addAll(query.list());
		
		return listCell;
    }

	@Override
	public Cell findRecordByBook(Cell cell) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Cell c where c.book.bookID = :id").setLong("id", cell.getBook().getBookID());
		List l = query.list();
		cell = l.size() == 0 ? null : (Cell) l.get(0);
		
		return cell;
	}

}
