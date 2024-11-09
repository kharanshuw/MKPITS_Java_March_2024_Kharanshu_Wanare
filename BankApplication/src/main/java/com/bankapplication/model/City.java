package com.bankapplication.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city_name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id")
    private District district;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
//	@JsonManagedReference
    private List<UserDetails> userDetails = new ArrayList<>(); // list of users

    // getter and setters

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

    public District getDistrict() {
	return district;
    }

    public void setDistrict(District district) {
	this.district = district;
    }

    public City() {
	super();
    }

    public List<UserDetails> getUserDetails() {
	return userDetails;
    }

    public void setUserDetails(List<UserDetails> userDetails) {
	this.userDetails = userDetails;
    }

    public boolean addUserDetails(UserDetails userDetails) {
	boolean result = this.userDetails.add(userDetails);
	if (result == true) {
	    System.out.println("userdetails added in city successfully");
	    return result;
	} else {
	    System.out.println("userdetails not added in city successfully");
	    return result;
	}
    }

    @Override
    public String toString() {
	return "City [id=" + id + ", name=" + name + ", district=" + district + ", userDetails=" + userDetails + "]";
    }

}
