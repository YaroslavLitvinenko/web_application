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
public class Cell {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cell_id")
    private Long cellID;
	@Column(name="name", nullable = false)
    private String cellNumber;
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", nullable = true)
    private Book book;
    
	public Cell() {}
	
	public Cell(Long cellID) {
		this.cellID = cellID;
	}
	
    public Cell(Long cellID, String cellNumber) {
		super();
		this.cellID = cellID;
		this.cellNumber = cellNumber;
	}

	public Cell(Long cellID, String cellNumber, Book book) {
		super();
		this.cellID = cellID;
		this.cellNumber = cellNumber;
		this.book = book;
	}

	public Cell(String cellNumber, Book book) {
		super();
		this.cellNumber = cellNumber;
		this.book = book;
	}
	
	public Cell(Book book) {
		this.book = book;
	}

	public Long getCellID() {
        return cellID;
    }
    
    public void setCellID(Long cellID) {
        this.cellID = cellID;
    }
    
    public String getCellNumber() {
        return cellNumber;
    }
    
    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }
    
    public Book getBook() {
        return book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cellID == null) ? 0 : cellID.hashCode());
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
		Cell other = (Cell) obj;
		if (cellID == null) {
			if (other.cellID != null)
				return false;
		} else if (!cellID.equals(other.cellID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cell [cellID=" + cellID + ", cellNumber=" + cellNumber + ", book=" + book.getName() + "]";
	}
}
