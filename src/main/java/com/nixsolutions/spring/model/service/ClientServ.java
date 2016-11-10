package com.nixsolutions.spring.model.service;

import java.util.ArrayList;

import com.nixsolutions.spring.model.db.entity.Client;

public interface ClientServ {
	public Client save(Client client);
    public void update(Client client);
    public void delete(Client client);
    
    public ArrayList<Client> findAll();
    public Client findByID(Client client);
    public Client findByUserID(Client client);
    public ArrayList<Client> findAvailable();
}
