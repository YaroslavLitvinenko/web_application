package com.nixsolutions.web.soap;


import javax.xml.bind.annotation.*;

import com.nixsolutions.spring.model.db.entity.User;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name = "createUserRequest")
public class CreateUserRequest {

	private String nickname;
	private String password;
	private String roles;
	
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

	public String getRoles() {
    	return roles;
    }
    
    public void setRoles(String roles) {
    	this.roles = roles;
    }
}
