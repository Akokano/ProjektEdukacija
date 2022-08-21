package com.citymanager.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citymanager.app.model.Country;
import com.citymanager.app.service.ICountryService;

@RestController
public class CountryController {
    private ICountryService countryService;

    public CountryController(ICountryService cs) {
        super();
        this.countryService = cs;
    }

    @GetMapping("/countries")
    public List<Country> findAll() {
        List<Country> countries = this.countryService.findAll();
        return countries;
    }

    @GetMapping("/countries/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Country country = this.countryService.findById(id);
        if (country == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Country with id " + id + " not found");
        }
        return ResponseEntity.ok(country);
    }

    @DeleteMapping("/countries/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        boolean success = this.countryService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Country with id " + id + " not found");
        }

        return ResponseEntity.ok(true);
    }

    @PostMapping("/countries")
    public ResponseEntity<?> create(@RequestBody Country country) {
        Country newCountry = this.countryService.create(country);
        return ResponseEntity.ok(newCountry);
    }

    @PutMapping("/countries/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Country formData) {
        Country updatedCountry = this.countryService.update(id, formData);
        if (updatedCountry == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Country with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedCountry);
    }
}
