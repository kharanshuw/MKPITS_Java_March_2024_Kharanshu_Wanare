package com.bankapplication.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "account_type")
@Entity
public class AccountType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type", nullable = false, unique = true)
    private String type;

    @ManyToMany(mappedBy = "accountType")
    private Set<Account> accounts = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
