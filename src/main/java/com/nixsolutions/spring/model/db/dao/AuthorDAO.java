package com.nixsolutions.spring.model.db.dao;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Author;

public interface AuthorDAO {
    public Author createRecord(Author author);
    public void updateRecord(Author author);
    public void deleteRecord(Author author);
    
    public ArrayList<Author> findAllRecord();
    public Author findRecordByID(Author author);
    public ArrayList<Author> findRecordByNameSurname(Author author);
}
