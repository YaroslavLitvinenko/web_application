package com.nixsolutions.spring.model.service;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Category;

public interface CategoryServ {
	public Category save(Category category);
    public void update(Category category);
    public void delete(Category category);
    
    public ArrayList<Category> findAll();
    public Category findByID(Category category);
    public Category findByName(Category category);
}
