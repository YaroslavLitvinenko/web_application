package com.nixsolutions.spring.model.service;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Admin;

public interface AdminServ {
	public Admin save(Admin admin);
	public void update(Admin admin);
	public void delete(Admin admin);
	
	public ArrayList<Admin> findAll();
    public Admin findByID(Admin admin);
    public Admin findByUser(Admin admin);
}