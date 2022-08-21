package com.citymanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
    
}
