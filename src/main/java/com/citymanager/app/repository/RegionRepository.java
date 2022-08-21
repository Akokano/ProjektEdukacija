package com.citymanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
    
}
