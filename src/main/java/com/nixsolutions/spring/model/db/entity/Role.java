package com.nixsolutions.spring.model.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
    private Long roleID;
	@Column(name="name", nullable = false)
	private String name;
    
	public Role() {}
	
	public Role(Long roleID, String name) {
		this.roleID = roleID;
		this.name = name;
	}
	
	public Role(String name) {
		this.name = name;
	}
	
	public Role(Long roleID) {
		this.roleID = roleID;
	}
	
    public Long getRoleID() {
        return roleID;
    }
    
    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleID == null) ? 0 : roleID.hashCode());
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
		Role other = (Role) obj;
		if (roleID == null) {
			if (other.roleID != null)
				return false;
		} else if (!roleID.equals(other.roleID))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Role [roleID=" + roleID + ", name=" + name + "]";
    }
}
