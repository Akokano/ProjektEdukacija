package com.citymanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
