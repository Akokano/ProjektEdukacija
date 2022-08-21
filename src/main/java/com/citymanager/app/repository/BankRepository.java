package com.citymanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
    
}
