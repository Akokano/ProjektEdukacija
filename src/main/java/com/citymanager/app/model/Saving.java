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
@Table (name = "savings")
public class Saving {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String purposeOfSaving;

    @Column
    private Number amountOfSaving;

    @Column (length = 3)
    private String currency;

    @Column
    private Integer interestRate;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn (name = "bank_id")
    private Bank bank;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;
}
