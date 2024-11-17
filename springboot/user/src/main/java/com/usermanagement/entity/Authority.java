package com.usermanagement.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "authorities")
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "role", nullable = false)
	@NotEmpty(message = "role must not be empty")
	@Pattern(regexp = "^[A-Z]+$", message = "Role must be uppercase letters only")
	private String role = "USER";

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "authorities")
	private List<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
}