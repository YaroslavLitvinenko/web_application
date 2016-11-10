package com.nixsolutions.spring.model.service;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Author;

public interface AuthorServ {
	public Author save(Author author);
    public void update(Author author);
    public void delete(Author author);
    
    public ArrayList<Author> findAll();
    public Author findByID(Author author);
    public ArrayList<Author> findByNameSurname(Author author);
}
