package com.nixsolutions.spring.model.db.dao.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nixsolutions.spring.model.db.dao.UserDAO;
import com.nixsolutions.spring.model.db.entity.User;

import org.hibernate.Query;


@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;

    @Override
    public User createRecord(User user) {
    	sessionFactory.getCurrentSession().save(user);
		return user;
    }

    @Override
    public void updateRecord(User user) {
    	sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteRecord(User user) {
    	sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public ArrayList<User> findAllRecord() {
		Query query = sessionFactory.getCurrentSession().createQuery("from User");
		ArrayList<User> listUser = new ArrayList<>();
		listUser.addAll(query.list());
		
		return listUser;
    }

    @Override
    public User findRecordByID(User user) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.userID = :id").setLong("id", user.getUserID());
		user = (User) query.list().get(0);
		
		return user;
    }

    @Override
    public User findRecordByLogin(User user) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.nickname = :login").setString("login", user.getNickname());
		
		if (query.list().size() > 0) {
			return user = (User) query.list().get(0);
		} else return null;
    }
    
    
}
