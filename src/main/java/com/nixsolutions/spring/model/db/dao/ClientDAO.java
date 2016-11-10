package com.nixsolutions.spring.model.db.dao;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Client;


public interface ClientDAO {
    public Client createRecord(Client client);
    public void updateRecord(Client client);
    public void deleteRecord(Client client);
    
    public ArrayList<Client> findAllRecord();
    public Client findRecordByID(Client client);
    public Client findRecordByUserID(Client client);
    public ArrayList<Client> findAvailableClients();
}
