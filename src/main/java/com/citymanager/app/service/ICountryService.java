package com.citymanager.app.service;

import java.util.List;

import com.citymanager.app.model.Country;

public interface ICountryService {
    Country findById(long id);
    List<Country> findAll();
    boolean delete(long id);
    Country create(Country country);
    Country update(long id, Country formData);
}
