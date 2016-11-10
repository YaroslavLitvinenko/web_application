package com.nixsolutions.spring.model.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nixsolutions.spring.model.db.dao.UserDAO;
import com.nixsolutions.spring.model.db.entity.User;
import com.nixsolutions.spring.model.service.UserServ;

@Service
@Transactional
public class UserServImpl implements UserServ {
	@Autowired
	UserDAO userDAO;
	
	@Override
	public User createRecord(User user) {
		return userDAO.createRecord(user);
	}

	@Override
	public void updateRecord(User user) {
		userDAO.updateRecord(user);
	}

	@Override
	public void deleteRecord(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<User> findAllRecord() {
		return userDAO.findAllRecord();
	}

	@Override
	public User findRecordByID(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findRecordByLogin(User user) {
		return userDAO.findRecordByLogin(user);
	}

}
