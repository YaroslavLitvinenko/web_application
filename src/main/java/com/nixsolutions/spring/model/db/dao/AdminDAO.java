package com.nixsolutions.spring.model.db.dao;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Admin;

public interface AdminDAO {
    public Admin createRecord(Admin admin);
    public void updateRecord(Admin admin);
    public void deleteRecord(Admin admin);
    
    public ArrayList<Admin> findAllRecord();
    public Admin findRecordByID(Admin admin);
    public Admin findRecordByUserID(Admin admin);
}