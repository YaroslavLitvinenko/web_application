package com.nixsolutions.spring.model.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="client_id")
    private Long clientID;
	@Column(name="first_name", nullable = false)
    private String firstName;
	@Column(name="last_name", nullable = false)
    private String lastName;
	@Column(name="phone_number", nullable = false)
    private String phoneNumber;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
    private User user;
    
	public Client() {}
	
	public Client(Long clientID) {
		this.clientID = clientID;
	}
	
    public Client(Long clientID, String firstName, String lastName, String phoneNumber) {
		super();
		this.clientID = clientID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public Client(String firstName, String lastName, String phoneNumber, User user) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.user = user;
	}
	
	public Client(String firstName) {
		this.firstName = firstName;
	}
	
	public Client(User user) {
		this.user = user;
	}
	
	public void update(Client client) {
		this.firstName = client.firstName;
		this.lastName = client.lastName;
		this.phoneNumber = client.phoneNumber;
		this.user.nickname = client.user.nickname;
		this.user.password = client.user.password;
	}

	public Long getClientID() {
        return clientID;
    }
    
    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientID == null) ? 0 : clientID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (clientID == null) {
			if (other.clientID != null)
				return false;
		} else if (!clientID.equals(other.clientID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return lastName + " " + firstName;
	}
}
