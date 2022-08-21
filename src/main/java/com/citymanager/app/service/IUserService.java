package com.citymanager.app.service;

import java.util.List;

import com.citymanager.app.model.User;


public interface IUserService {
    User findById(long id);
    List<User> findAll();
    boolean delete (long Id);
    User create (User user);
    User update (long id, User fromData);
    
}
