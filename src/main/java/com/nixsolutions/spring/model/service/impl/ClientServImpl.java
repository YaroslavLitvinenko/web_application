package com.nixsolutions.spring.model.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nixsolutions.spring.model.db.dao.ClientDAO;
import com.nixsolutions.spring.model.db.dao.RoleDAO;
import com.nixsolutions.spring.model.db.dao.UserDAO;
import com.nixsolutions.spring.model.db.entity.Client;
import com.nixsolutions.spring.model.db.entity.Role;
import com.nixsolutions.spring.model.service.ClientServ;
import com.nixsolutions.spring.model.service.RoleServ;

@Service
@Transactional
public class ClientServImpl implements ClientServ {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ClientDAO clientDAO;
	@Autowired
	RoleDAO roleDAO;
	@Autowired
	UserDAO userDAO;
	
	@Override
	public Client save(Client client) {
		List<Role> roles = new ArrayList<>();
		roles.add(roleDAO.findRecordByName(new Role("Reader")));
		client.getUser().setRoles(roles);
		
		return clientDAO.createRecord(client);
	}

	@Override
	public void update(Client client) {
		Client clientForUpdate = clientDAO.findRecordByID(client);
		clientForUpdate.update(client);
		
		clientDAO.updateRecord(clientForUpdate);
	}

	@Override
	public void delete(Client client) {
		clientDAO.deleteRecord(clientDAO.findRecordByID(client));
	}

	@Override
	public ArrayList<Client> findAll() {
		return clientDAO.findAllRecord();
	}

	@Override
	public Client findByID(Client client) {
		return clientDAO.findRecordByID(client);
	}

	@Override
	public Client findByUserID(Client client) {
		return clientDAO.findRecordByUserID(client);
	}

	@Override
	public ArrayList<Client> findAvailable() {
		return clientDAO.findAvailableClients();
	}

}
