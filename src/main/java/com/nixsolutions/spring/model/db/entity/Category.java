package com.nixsolutions.spring.model.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Bean;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
    private Long categoryID;
	@Column(name="name", nullable = false)
    private String name;

	
	public Category() {}
	
	public Category(Long categoryID) {
		this.categoryID = categoryID;
	}
	
	public Category(Long categoryID, String name) {
		this.categoryID = categoryID;
		this.name = name;
	}
	
    public Category(String name) {
		super();
		this.name = name;
	}

	public Long getCategoryID() {
        return categoryID;
    }
    
    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
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
		result = prime * result + ((categoryID == null) ? 0 : categoryID.hashCode());
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
		Category other = (Category) obj;
		if (categoryID == null) {
			if (other.categoryID != null)
				return false;
		} else if (!categoryID.equals(other.categoryID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", name=" + name + "]";
	}
}
