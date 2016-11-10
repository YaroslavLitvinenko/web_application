package com.nixsolutions.spring.model.db.dao;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Role;


public interface RoleDAO {
    public Role createRecord(Role role);
    public void updateRecord(Role role);
    public void deleteRecord(Role role);
    
    public ArrayList<Role> findAllRecord();
    public Role findRecordByID(Role role);
    public Role findRecordByName(Role role);
}
