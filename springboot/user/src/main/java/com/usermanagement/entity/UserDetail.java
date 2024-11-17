package com.usermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import  com.usermanagement.entity.User;


/**
 * Represents additional details about a user.
 */

@Entity
@Table(name = "user_details")
public class UserDetail {

	 /**
     * Unique identifier for the user details.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * User's phone number.
     */
    @NotNull(message = "phone no must not be null")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number format (10 digits)")
    private String phoneno;

    /**
     * User's first name.
     */
    @Size(max = 50, message = "First name must not exceed 50 characters")
    private String fname;

    /**
     * User's last name.
     */
    @Size(max = 50, message = "Last name must not exceed 50 characters")
    private String lname;

    /**
     * User's gender.
     */
    @NotNull(message = "Gender must not be null")
    @Pattern(regexp = "^(MALE|FEMALE|OTHER)$", message = "Invalid gender")
    private String gender;
    
    
    /**
     * User's city.
     */
    @Size(max = 50, message = "City must not exceed 50 characters")
    private String city;

    
    /**
     * Associated user.
     */
    @OneToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "User must not be null")
    private User user;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}