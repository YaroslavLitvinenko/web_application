package com.nixsolutions.spring.model.db.dao.impl;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nixsolutions.spring.model.db.dao.CategoryDAO;
import com.nixsolutions.spring.model.db.entity.Category;

import org.hibernate.Query;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	
    @Override
    public Category createRecord(Category category) {
    	sessionFactory.getCurrentSession().save(category);
		return category;
    }

    @Override
    public void updateRecord(Category category) {
    	sessionFactory.getCurrentSession().update(category);
    }

    @Override
    public void deleteRecord(Category category) {
    	sessionFactory.getCurrentSession().delete(category);
    }

    @Override
    public ArrayList<Category> findAllRecord() {
		ArrayList<Category> listCategory = new ArrayList<>();
		listCategory.addAll(sessionFactory.getCurrentSession().createCriteria(Category.class).list());
		
		return listCategory;
    }
    
    public Category findRecordByID(Category category) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Category c where c.categoryID = :id").setLong("id", category.getCategoryID());
		category = (Category) query.list().get(0);
		
		return category;
    }

    @Override
    public Category findRecordByName(Category category) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Category c where c.name = :name").
				setString("name", category.getName());
		category = (Category) query.list().get(0);
		
		return category;
    }

}
