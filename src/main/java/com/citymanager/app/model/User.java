package com.citymanager.app.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name = "users")
public class User {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false)
    private String firstName;

    @Column (nullable = false)
    private String lastName;

    @Column (nullable = false)
    private String gender;

    @Column (nullable = false)
    private LocalDate birthDate;
    
    @Column (nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn (name = "city_id")
    private City city;
}
