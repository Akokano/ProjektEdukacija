package com.citymanager.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citymanager.app.model.User;
import com.citymanager.app.repository.UserRepository;
import com.citymanager.app.service.IUserService;

@Service
public class UserService implements IUserService {
    
    private UserRepository users;

    public UserService(UserRepository ur) {
        super();
        this.users = ur;

    }

    @Override
    public User findById(long id) {
        try {
            return this.users.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return this.users.findAll();
    }

    @Override
    public boolean delete(long id) {
        User u = this.findById(id);
        try {
            this.users.delete(u);
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    @Override
    public User create(User u) {
        u = this.users.save(u);
        return u;
    }

    @Override
    public User update(long id, User fromData) {
        User oldUser = this.findById(id);

        if(oldUser ==null) {
            return null;
        }

        oldUser.setFirstName(fromData.getFirstName());
        oldUser.setLastName(fromData.getLastName());
        oldUser.setGender(fromData.getGender());
        oldUser.setBirthDate(fromData.getBirthDate());
        oldUser.setPhoneNumber(fromData.getPhoneNumber());
        oldUser.setCity(fromData.getCity());

        return this.users.save(oldUser);

    }

    
}
