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
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city_name", nullable = false)
    private String name;

    

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id")
    private District district;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<UserDetails> userDetails;

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

    public List<UserDetails> getUserDetails() {
	return userDetails;
    }

    public void setUserDetails(List<UserDetails> userDetails) {
	this.userDetails = userDetails;
    }

    public City() {
	super();
    }

    @Override
    public String toString() {
	return "City [id=" + id + ", name=" + name + ", district=" + district + ", userDetails=" + userDetails + "]";
    }

}
