package com.bankapplication.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "password", nullable = false)
    @Size(min = 8, max = 128, message = "password length must be between 0 to 128")
    @NotEmpty(message = "password should not be empty")
    @Pattern(regexp = "\\{noop\\}(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,128}$",
    message = "Password must meet requirements (8-128 chars, uppercase, lowercase, digit, special char)")
    private String password;

    @Column(name = "email", unique = true)
    @NotEmpty(message = "email should not be empty")
    @NotNull(message = "email should not be empty")
    private String email;

    @Column(name = "enable")
    private boolean isActive = true;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private UserDetails userDetails;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> role;




    public int getId() {
        return id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }


    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", password=" + password + ", email=" + email + ", isActive=" + isActive
                + ", userDetails=" + userDetails + ", role=" + role + "]";
    }


    public User(int id,
                @Size(min = 8, max = 128, message = "password length must be between 0 to 128") @NotEmpty(message = "password should not be empty") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,128}$", message = "Password must meet requirements (8-128 chars, uppercase, lowercase, digit, special char)") String password,
                @NotEmpty(message = "email should not be empty") @NotNull(message = "email should not be empty") String email,
                boolean isActive, UserDetails userDetails, Set<Role> role) {
        super();
        this.id = id;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
        this.userDetails = userDetails;
        this.role = role;
    }

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }


}