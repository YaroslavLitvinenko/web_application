package com.nixsolutions.spring.model.service.impl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nixsolutions.spring.model.db.dao.RoleDAO;
import com.nixsolutions.spring.model.db.entity.Role;
import com.nixsolutions.spring.model.service.RoleServ;

@Service
@Transactional
public class RoleServImpl implements RoleServ{
	@Autowired
	RoleDAO roleDAO;

	@Override
	public Role save(Role role) {
		return null;
	}

	@Override
	public void update(Role role) {
	}

	@Override
	public void delete(Role role) {
	}

	@Override
	public ArrayList<Role> findAll() {
		return null;
	}

	@Override
	public Role findByID(Role role) {
		return roleDAO.findRecordByID(role);
	}

	@Override
	public Role findByName(Role role) {
		return roleDAO.findRecordByName(role);
	}

}
