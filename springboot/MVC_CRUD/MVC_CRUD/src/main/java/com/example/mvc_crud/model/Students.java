package com.example.mvc_crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Students {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String address;
    private float percentage;
    private String country;

    public Students(String name, String city, String address, float percentage,
                    String country) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.percentage = percentage;
        this.country = country;
    }
}
