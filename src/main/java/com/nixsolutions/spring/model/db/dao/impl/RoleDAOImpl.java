package com.nixsolutions.spring.model.db.dao.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nixsolutions.spring.model.db.dao.RoleDAO;
import com.nixsolutions.spring.model.db.entity.Role;

import org.hibernate.Query;


@Repository
public class RoleDAOImpl implements RoleDAO {
	@Autowired
	SessionFactory sessionFactory;
    
    @Override
    public Role createRecord(Role role) {
    	sessionFactory.getCurrentSession().save(role);
		return role;
    }

    @Override
    public void updateRecord(Role role) {
    	sessionFactory.getCurrentSession().update(role);
    }

    @Override
    public void deleteRecord(Role role) {
    	sessionFactory.getCurrentSession().delete(role);
    }

    @Override
    public ArrayList<Role> findAllRecord() {
		ArrayList<Role> listRole = new ArrayList<>();
		listRole.addAll(sessionFactory.getCurrentSession().createCriteria(Role.class).list());
		
		return listRole;
    }

    @Override
    public Role findRecordByID(Role role) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Role r where r.roleID = :id").setLong("id", role.getRoleID());
		role = (Role) query.list().get(0);
		
		return role;
    }

    @Override
    public Role findRecordByName(Role role) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Role r where r.name = :name").setString("name", role.getName());
		role = (Role) query.list().get(0);
		
		return role;
    }
}
