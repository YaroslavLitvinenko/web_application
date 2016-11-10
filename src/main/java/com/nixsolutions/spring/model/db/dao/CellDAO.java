package com.nixsolutions.spring.model.db.dao;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Cell;


public interface CellDAO {
    public Cell createRecord(Cell cell);
    public void updateRecord(Cell cell);
    public void deleteRecord(Cell cell);
    
    public ArrayList<Cell> findAllRecord();
    public Cell findRecordByID(Cell cell);
    public ArrayList<Cell> findRecordByEmptyCell();
    public Cell findRecordByBook(Cell cell);
}
