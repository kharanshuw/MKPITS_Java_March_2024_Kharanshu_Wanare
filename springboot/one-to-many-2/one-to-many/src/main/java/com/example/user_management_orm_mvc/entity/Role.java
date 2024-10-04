package com.example.user_management_orm_mvc.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roleName;
    @ManyToMany
    @JoinTable(
            name="user_role",
            joinColumns = @JoinColumn(name="role_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private List<User> user;
}
//inverse join column for many to many