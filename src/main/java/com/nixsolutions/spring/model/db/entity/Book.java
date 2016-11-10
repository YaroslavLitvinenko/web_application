package com.nixsolutions.spring.model.db.entity;

import java.util.HashSet;
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
import javax.persistence.ManyToOne;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_id")
    private Long bookID;
	@Column(name="name", nullable = false)
    private String name;
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false)
    private Category category;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_author", joinColumns = {@JoinColumn(name = "book_id")}, inverseJoinColumns={@JoinColumn(name = "author_id")})
    private Set<Author> authors;

	public Book() {}
	
	public Book(Long bookID) {
		this.bookID = bookID;
	}
	
    public Book(Long bookID, String name) {
		super();
		this.bookID = bookID;
		this.name = name;
	}

	public Book(String name) {
		super();
		this.name = name;
	}
	
	public Book(Category category) {
		super();
		this.category = category;
	}

	public Long getBookID() {
        return bookID;
    }
    
    public void setBookID(Long book_id) {
        this.bookID = book_id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Category getCategory() {
    	return category;
    }
    
    public void setCategory(Category category) {
    	this.category = category;
    }
    
    public Set<Author> getAuthors() {
    	return authors;
    }
    
    public void setAuthors(Set<Author> authors) {
    	this.authors = authors;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookID == null) ? 0 : bookID.hashCode());
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
		Book other = (Book) obj;
		if (bookID == null) {
			if (other.bookID != null)
				return false;
		} else if (!bookID.equals(other.bookID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + bookID + "] " + name;
	}
    
    
}
