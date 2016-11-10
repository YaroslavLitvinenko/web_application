package com.nixsolutions.spring.model.db.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class Journal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="record_id")
    private Long recordID;
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", nullable = false)
    private Book book;
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id", nullable = false)
    private Client client;
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;
	@Column(name="date_issue", nullable = false)
	@Type(type="timestamp")
    private Date dateIssue;
	@Column(name="date_return", nullable = false)
	@Type(type="timestamp")
    private Date dateReturn;
	@Column(name="date_fact_return", nullable = true)
	@Type(type="timestamp")
    private Date dateFactReturn;
    
	public static final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	
	public Journal() {}
	
	public Journal(Long recordID) {
		this.recordID = recordID;
	}
    
    public Journal(Book book, Client client, Admin admin, Date dateIssue, Date dateReturn) {
		super();
		this.book = book;
		this.client = client;
		this.admin = admin;
		this.dateIssue = dateIssue;
		this.dateReturn = dateReturn;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

    public Long getRecordID() {
        return recordID;
    }

    public void setRecordID(Long recordID) {
        this.recordID = recordID;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }
    
    public void setDateIssue(String dateIssue) throws ParseException {
    	this.dateIssue = formater.parse(dateIssue);
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public Date getDateFactReturn() {
        return dateFactReturn;
    }

    public void setDateFactReturn(Date dateFactReturn) {
        this.dateFactReturn = dateFactReturn;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recordID == null) ? 0 : recordID.hashCode());
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
		Journal other = (Journal) obj;
		if (recordID == null) {
			if (other.recordID != null)
				return false;
		} else if (!recordID.equals(other.recordID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Journal [recordID=" + recordID + ", book=" + book + ", client=" + client + ", admin=" + admin
				+ ", dateIssue=" + dateIssue + ", dateReturn=" + dateReturn + ", dateFactReturn=" + dateFactReturn
				+ "]";
	}
}
