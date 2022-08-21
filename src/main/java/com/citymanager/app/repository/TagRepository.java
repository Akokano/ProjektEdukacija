package com.citymanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
    
}
