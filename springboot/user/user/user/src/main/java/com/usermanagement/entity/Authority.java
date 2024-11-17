package com.usermanagement.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role")
    private String role = "ROLE_USER";

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "authorities")
    private List<User> users;

}