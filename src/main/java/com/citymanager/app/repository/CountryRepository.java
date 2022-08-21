package com.citymanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
    
}
