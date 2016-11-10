package com.nixsolutions.spring.model.db.dao;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Category;


public interface CategoryDAO {
    public Category createRecord(Category category);
    public void updateRecord(Category category);
    public void deleteRecord(Category category);
    
    public ArrayList<Category> findAllRecord();
    public Category findRecordByID(Category category);
    public Category findRecordByName(Category category);
}
