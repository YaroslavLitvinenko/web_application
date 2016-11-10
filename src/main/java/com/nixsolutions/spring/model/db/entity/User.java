package com.nixsolutions.spring.model.db.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
    Long userID;
	@Column(name="nickname", nullable = false)
    String nickname;
	@Column(name="password", nullable = false)
    String password;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns={@JoinColumn(name = "role_id")})
    private List<Role> roles;

	public User() {}
	
	public User(String nickname) {
		this.nickname = nickname;
	}
	
	public User(Long userID) {
		this.userID = userID;
	}
	
	public User(Long userID, String nickname, String password) {
		this.userID = userID;
		this.nickname = nickname;
		this.password = password;
	}
	
    public User(String nickname, String password) {
		super();
		this.nickname = nickname;
		this.password = password;
	}

	public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean access(String roleName) {
    	for (Role role : roles)
    		if (role.getName().equals(roleName))
    			return true;
    	return false;
    }
    
    public boolean access(Role role) {
    	return access(role.getName());
    }
    
    public List<Role> getRoles() {
    	return roles;
    }
    
    public void setRoles(List<Role> roles) {
    	this.roles = roles;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
		User other = (User) obj;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String str = "User [userID=" + userID + ", nickname=" + nickname + ", password=" + password + 
				", roles=";
		for (Role role : roles) {
			str += role.getName() + " ";
		}
		str += "]";
		return str;
	}
    
    
}
