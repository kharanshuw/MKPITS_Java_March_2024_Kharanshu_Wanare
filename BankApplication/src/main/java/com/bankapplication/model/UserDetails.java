package com.bankapplication.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "userdetails")
@EntityListeners(AuditingEntityListener.class)
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fname")
	@NotEmpty(message = "First name cannot be empty")
	@Size(min = 2, max = 50, message = "First name must be between 2 to 50 characters")
	private String fname;

	@Column(name = "lname")
	@NotEmpty(message = "Last name cannot be empty")
	@Size(min = 2, max = 50, message = "Last name must be between 2 to 50 characters")
	private String lname;

	@Column(name = "phoneno")
	@NotEmpty(message = "Phone number cannot be empty")
	@Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
	private String phoneno;

	@Column(name = "gender")
	@NotEmpty(message = "gender should not be empty")
	private String gender;

	// created date should be inserted 1st time only
	// update not
	@CreatedDate
	@Column(name = "create_at", nullable = false, updatable = false)
	private LocalDateTime createdate;

	// lastmodified date should be updated only
	// insert date not allowd
	@LastModifiedDate
	@Column(name = "lastmodified_at", insertable = false)
	private LocalDateTime lastmodified;

	// createdby should be inserted 1st time only
	// update not
	@CreatedBy
	@Column(name = "create_by", nullable = false, updatable = false)
	private Integer createBy;

	// lastmodifiedby should be updated only
	// insert not
	@LastModifiedBy
	@Column(name = "lastmodified_by", insertable = false)
	private Integer lastmodifiedby;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@PrePersist
	public void prepersist() {
		this.createBy=getcurrentuserid();
		this.createdate=LocalDateTime.now();
	}
	
	public Integer getcurrentuserid() {
		Integer idInteger=user.getId();
		return idInteger;
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedate() {
		return createdate;
	}

	public void setCreatedate(LocalDateTime createdate) {
		this.createdate = createdate;
	}

	public LocalDateTime getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(LocalDateTime lastmodified) {
		this.lastmodified = lastmodified;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Integer getLastmodifiedby() {
		return lastmodifiedby;
	}

	public void setLastmodifiedby(Integer lastmodifiedby) {
		this.lastmodifiedby = lastmodifiedby;
	}
	
	
	
}
