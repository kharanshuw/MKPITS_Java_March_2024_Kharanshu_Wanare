package com.bankapplication.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "country_name")
    private String name;
    
    
    @Column(name = "country_code")
    private int countrycode;

    @JsonBackReference
    @OneToMany(mappedBy = "country")
    private List<State> states;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<State> getStates() {
	return states;
    }

    public void setStates(List<State> states) {
	this.states = states;
    }

    public Country(int id, String name, List<State> states) {
	super();
	this.id = id;
	this.name = name;
	this.states = states;
    }

    public Country() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
	return "Country [id=" + id + ", name=" + name + ", states=" + states + "]";
    }

}
