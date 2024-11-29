package com.bankapplication.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private UserDetails userDetails;
    
    @Column(name = "account_number")
    private String accountNumber;
    
    @Column(name = "balance")
    @Size(min = 0)
    private double balance;
    
    @ManyToMany
    @JoinTable(
            name = "account_account_type_mapping",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "account_type_id")
    )
    private Set<AccountType> accountType=new HashSet<>();
    
    
}
