package com.citymanager.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citymanager.app.model.Country;
import com.citymanager.app.repository.CountryRepository;
import com.citymanager.app.service.ICountryService;

@Service
public class CountryService implements ICountryService {

    private CountryRepository countries;

    public CountryService(CountryRepository cr) {
        super();
        this.countries = cr;
    }

    @Override
    public Country findById(long id) {
        try {
            return this.countries.findById(id).get();
            } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Country> findAll() {
        return this.countries.findAll();
    }

    @Override
    public boolean delete(long id) {
        Country c = this.findById(id);
        try {
            this.countries.delete(c);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Country create(Country c) {
        c = this.countries.save(c);
        return c;
    }

    @Override
    public Country update(long id, Country formData) {
        Country oldCountry = this.findById(id);

        if (oldCountry == null) {
            return null;
        }

        oldCountry.setCountryName(formData.getCountryName());

        return this.countries.save(oldCountry);
    }


    
}
