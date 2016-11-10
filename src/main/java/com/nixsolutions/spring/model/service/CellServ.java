package com.nixsolutions.spring.model.service;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Cell;

public interface CellServ {
	public Cell save(Cell cell);
    public void update(Cell cell);
    public void delete(Cell cell);
    public void take(Cell cell);
    
    public ArrayList<Cell> findAll();
    public Cell findByID(Cell cell);
    public ArrayList<Cell> findByEmptyCell();
    public Cell findByBook(Cell cell);
}
