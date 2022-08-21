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

import com.citymanager.app.model.Region;
import com.citymanager.app.service.IRegionService;

@RestController
public class RegionController {

    private IRegionService regionService;

    public RegionController(IRegionService rs){
        super();
        this.regionService = rs;

    }

    @GetMapping("/regions")
    public List<Region> findAll() {
        List<Region> regions =this.regionService.findAll();
        return regions;
    }

    @GetMapping("/regions/{id}")
        public ResponseEntity<?> findById(@PathVariable Long id) {
            Region region = this.regionService.findById(id);
            if (region == null){
                return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Region with id" + id + " not found.");
            }
            return ResponseEntity.ok(region);
        }

    @DeleteMapping("/regions/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean success = this.regionService.delete(id);
        if(!success){
            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Region with id " + id + " not found. ");
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping ("/regions")
    public ResponseEntity<?> create (@RequestBody Region region ) {
        Region newRegion = this.regionService.create(region);
        return ResponseEntity.ok(newRegion);
    }

    @PutMapping ("/regions/{id}")
    public ResponseEntity<?> update (@PathVariable Long id, @RequestBody Region fromData) {
        Region updatedRegion = this.regionService.update(id, fromData);
        if (updatedRegion == null) {
            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Region with " + id + " not found.");
        }
        return ResponseEntity.ok(updatedRegion);
    }
    }


