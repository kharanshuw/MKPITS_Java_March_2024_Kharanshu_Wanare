package com.example.user_management_orm_mvc.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phoneNo;
    private String email;
    @OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL)
    private User user;

    public User_Details(String name, String address, String phoneNo, String email, User user) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
        this.user = user;
    }
}
