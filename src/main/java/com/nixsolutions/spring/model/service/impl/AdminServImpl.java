package com.nixsolutions.spring.model.service.impl;

import java.util.ArrayList;

import javax.persistence.Transient;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nixsolutions.spring.model.db.dao.AdminDAO;
import com.nixsolutions.spring.model.db.entity.Admin;
import com.nixsolutions.spring.model.service.AdminServ;

@Service
@Transactional
public class AdminServImpl implements AdminServ {
	@Autowired
	AdminDAO adminDAO;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Admin save(Admin admin) {
		return adminDAO.createRecord(admin);
	}

	@Override
	public void update(Admin admin) {
		adminDAO.updateRecord(admin);
	}

	@Override
	public void delete(Admin admin) {
		adminDAO.deleteRecord(adminDAO.findRecordByID(admin));
	}

	@Override
	public ArrayList<Admin> findAll() {
		return adminDAO.findAllRecord();
	}

	@Override
	public Admin findByID(Admin admin) {
		return adminDAO.findRecordByID(admin);
	}

	@Override
	public Admin findByUser(Admin admin) {
		return adminDAO.findRecordByUserID(admin);
	}
	
	

}
