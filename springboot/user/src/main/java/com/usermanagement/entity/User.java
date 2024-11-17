// User Entity representing a user in the database
package com.usermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

/** 
 * User Entity
 * 
 * This class represents a user in the database and defines the structure of the users table.
 * 
 *@author [Kharanshu Wanare]
 */
@Table(name = "users") // Specify the database table name
@Entity // Indicate this class is an entity
public class User {

    // Unique identifier for the user
    @Id // Specify this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the ID
    private int id;

    // User password
    @Column(name = "password") // Specify the database column name
    @NotEmpty(message = "Password must not be empty") // Validate password is not empty
    @Size(min = 8, max = 128, message = "Password size must be from 8 to 128 characters") // Validate password length
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
             message = "Password must contain at least one lowercase letter, one uppercase letter, one digit, and one special character")
    private String password;

    // Flag indicating whether the user is enabled
    @Column(name = "enabled") // Specify the database column name
    private boolean isEnabled = true; // Default to enabled

    // One-to-one relationship with UserDetail
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // Specify the relationship
    @NotNull(message = "User details must not be null") // Validate user details are not null
    private UserDetail userDetail;

    // User email
    @Column(name = "email", unique = true) // Specify the database column name and uniqueness constraint
    @NotEmpty(message = "Email is required") // Validate email is not empty
    @Email(message = "Email is invalid") // Validate email format
    private String email;

    // Many-to-many relationship with Authority
    @ManyToMany(cascade = CascadeType.ALL) // Specify the relationship
    @JoinTable(
            name = "users_authorities", // Specify the join table name
            joinColumns = @JoinColumn(name = "user_id"), // Specify the join column
            inverseJoinColumns = @JoinColumn(name = "authorities_id")
    )
    @NotEmpty(message = "At least one role should be assigned") // Validate at least one role is assigned
    private List<Authority> authorities;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}