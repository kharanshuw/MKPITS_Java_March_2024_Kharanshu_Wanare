package com.bankapplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

	@Id
	private int id;

	@Column(name = "role_name")
	private String rolename;
	
	@ManyToMany(mappedBy = "role",fetch = FetchType.LAZY)
	private Set<User> user;



	public Role(int id, String rolename, Set<User> user) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.user = user;
	}

	public Role() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	
	
	

	
}
