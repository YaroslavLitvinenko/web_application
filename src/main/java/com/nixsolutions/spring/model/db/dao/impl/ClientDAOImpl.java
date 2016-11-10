package com.nixsolutions.spring.model.db.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nixsolutions.spring.model.db.dao.ClientDAO;
import com.nixsolutions.spring.model.db.entity.Client;

import org.hibernate.Criteria;
import org.hibernate.Query;


@Repository
public class ClientDAOImpl implements ClientDAO {
	@Autowired
	SessionFactory sessionFactory;

    @Override
    public Client createRecord(Client client) {
    	sessionFactory.getCurrentSession().save(client);
		return client;
    }

    @Override
    public void updateRecord(Client client) {
    	sessionFactory.getCurrentSession().update(client);
    }

    @Override
    public void deleteRecord(Client client) {
    	sessionFactory.getCurrentSession().delete(client);
    }

    @Override
    public ArrayList<Client> findAllRecord() {
		ArrayList<Client> listClient = new ArrayList<>();
		listClient.addAll(sessionFactory.getCurrentSession().createCriteria(Client.class).list());
		
		return listClient;
    }

    @Override
    public Client findRecordByID(Client client) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Client c where c.clientID = :id").setLong("id", client.getClientID());
		client = (Client) query.list().get(0);
		
		return client;
    }

    @Override
    public Client findRecordByUserID(Client client) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Client c where c.user.userID = :id").setLong("id", client.getUser().getUserID());
		client = (Client) query.list().get(0);
		
		return client;
    }
    
    @Override
    public ArrayList<Client> findAvailableClients() {
    	Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select j.client.clientID from Journal j GROUP BY j.client.clientID "
		 		+ "having count(j.client.clientID)>1");
		List<Long> listJournal = query.list();
		
		query = session.createQuery("from Client c where c.clientID not in :client").setParameterList("client", listJournal);
		ArrayList<Client> listClient = new ArrayList<>();
		listClient.addAll(query.list());
		
		return listClient;
    }
} 
