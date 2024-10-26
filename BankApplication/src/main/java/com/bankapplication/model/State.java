package com.bankapplication.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "state")
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "state_name")
	private String nameString;
	
	@Column(name = "state_code")
	private int statecode;

	@OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
	private List<District> districts;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id")
	private Country country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
	    return "State [id=" + id + ", nameString=" + nameString + ", districts=" + districts + ", country="
		    + country + "]";
	}

	public State(int id, String nameString, List<District> districts, Country country) {
	    super();
	    this.id = id;
	    this.nameString = nameString;
	    this.districts = districts;
	    this.country = country;
	}

	public State() {
	    super();
	    // TODO Auto-generated constructor stub
	}

}
