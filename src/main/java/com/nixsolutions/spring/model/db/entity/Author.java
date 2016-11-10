package com.nixsolutions.spring.model.db.entity;

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
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="author_id")
    private Long authorID;
	@Column(name="first_name", nullable = false)
    private String firstName;
	@Column(name="last_name", nullable = false)
    private String lastName;
	@Column(name="middle_name", nullable = true)
    private String middleName;
	@ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinTable(name = "book_author", joinColumns = {@JoinColumn(name = "author_id")}, inverseJoinColumns={@JoinColumn(name = "book_id")})
    private Set<Book> books;

	public Author() {}
	
	public Author(Long authorID) {
		this.authorID = authorID;
	}
	
    public Long getAuthorID() {
        return authorID;
    }
    
    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }
    
    public Author(Long authorID, String firstName, String lastName, String middleName) {
		super();
		this.authorID = authorID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
	}

	public Author(String firstName, String lastName, String middleName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
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
    
    public String getMiddleName() {
        return middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorID == null) ? 0 : authorID.hashCode());
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
		Author other = (Author) obj;
		if (authorID == null) {
			if (other.authorID != null)
				return false;
		} else if (!authorID.equals(other.authorID))
			return false;
		return true;
	}

	@Override
    public String toString() {
    	String str = lastName + " " + firstName.substring(0, 1) + ".";
    	if (middleName != null)
    		str += " " + middleName.substring(0, 1) + ".";
        return str;
    }
}
