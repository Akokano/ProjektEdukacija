package com.citymanager.app.service;

import java.util.List;

import com.citymanager.app.model.City;

public interface ICityService {
    City findById(long id);
    List<City> findAll();
    boolean delete (long id);
    City create(City city);
    City update(long id, City fromData);
}
