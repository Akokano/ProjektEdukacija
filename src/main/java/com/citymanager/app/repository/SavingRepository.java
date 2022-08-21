package com.citymanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.Saving;

public interface SavingRepository extends JpaRepository <Saving, Long>{
    
}
