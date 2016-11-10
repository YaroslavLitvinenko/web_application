package com.nixsolutions.spring.model.db.dao;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.User;


public interface UserDAO {
    public User createRecord(User user);
    public void updateRecord(User user);
    public void deleteRecord(User user);
    
    public ArrayList<User> findAllRecord();
    public User findRecordByID(User user);
    public User findRecordByLogin(User user);
}
