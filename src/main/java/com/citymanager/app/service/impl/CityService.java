package com.citymanager.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citymanager.app.model.City;
import com.citymanager.app.repository.CityRepository;
import com.citymanager.app.service.ICityService;

@Service
public class CityService implements ICityService {

    private CityRepository cities;

    public CityService(CityRepository cr) {
        super();
        this.cities = cr;
    }

    @Override
    public City create(City c) {
        c = this.cities.save(c);
        return c;
    }

    @Override
    public boolean delete(long id) {
        City c = this.findById(id);
        try {
            this.cities.delete(c);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<City> findAll() {
        return this.cities.findAll();
    }

    @Override
    public City findById(long id) {
        try {
            return this.cities.findById(id).get();
        } catch (Exception e ) {
            return null;
        }
    }

    @Override
    public City update(long id, City fromData) {
        City oldCity = this.findById(id);

        if (oldCity == null) {
            return null;
        }

        oldCity.setCityName(fromData.getCityName());

        return this.cities.save(oldCity);
    }
}
