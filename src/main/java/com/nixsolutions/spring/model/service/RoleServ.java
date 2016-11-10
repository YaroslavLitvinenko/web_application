package com.nixsolutions.spring.model.service;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Role;

public interface RoleServ {
	public Role save(Role role);
    public void update(Role role);
    public void delete(Role role);
    
    public ArrayList<Role> findAll();
    public Role findByID(Role role);
    public Role findByName(Role role);
}
