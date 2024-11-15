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
	private Set<Users> users;



	public Role(int id, String rolename, Set<Users> users) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.users = users;
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

	public Set<Users> getUser() {
		return users;
	}

	public void setUser(Set<Users> users) {
		this.users = users;
	}

	
	
	

	
}
