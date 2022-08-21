package com.citymanager.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citymanager.app.model.City;
import com.citymanager.app.service.ICityService;

@RestController
public class CityController {
    private ICityService cityService;

    public CityController(ICityService cs) {
        super();
        this.cityService = cs;
    }

    @GetMapping("/cities")
    public List<City> findAll() {
        List<City> cities = this.cityService.findAll();
        return cities;
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        City city = this.cityService.findById(id);
        if (city == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("City with id " + id + " not found");
        }
        return ResponseEntity.ok(city);
    }

    @DeleteMapping("/cities/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        boolean success = this.cityService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("City with id " + id + " not found.");
        }
        
        return ResponseEntity.ok(true);
    }

    @PostMapping("/cities")
    public ResponseEntity<?> create (@RequestBody City city) {
        City newCity = this.cityService.create(city);
        return ResponseEntity.ok(newCity);
    }

    @PostMapping("/cities/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody City fromData) {
        City updatedCity = this.cityService.update(id, fromData);
        if (updatedCity == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("City with id " + id + " not found.");
        }
        return ResponseEntity.ok(updatedCity);
    }
}

