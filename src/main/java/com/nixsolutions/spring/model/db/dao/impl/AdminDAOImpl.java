package com.nixsolutions.spring.model.db.dao.impl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nixsolutions.spring.model.db.dao.AdminDAO;
import com.nixsolutions.spring.model.db.entity.Admin;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Admin createRecord(Admin admin) {
		sessionFactory.getCurrentSession().save(admin);
		return admin;
	}

	@Override
	public void updateRecord(Admin admin) {
		sessionFactory.getCurrentSession().update(admin);
	}

	@Override
	public void deleteRecord(Admin admin) {
		sessionFactory.getCurrentSession().delete(admin);
	}
	
	@Override
	public ArrayList<Admin> findAllRecord() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Admin");
		ArrayList<Admin> listAdmin = new ArrayList<>();
		listAdmin.addAll(query.list());
		return listAdmin;
	}

	@Override
	public Admin findRecordByID(Admin admin) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Admin a where a.adminID = :id").setLong("id", admin.getAdminID());
		admin = (Admin) query.list().get(0);
		
		return admin;
	}

	@Override
	public Admin findRecordByUserID(Admin admin) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Admin a where a.user.userID = :id").setLong("id", admin.getUser().getUserID());
		admin = (Admin) query.list().get(0);
		
		return admin;
	}

}
