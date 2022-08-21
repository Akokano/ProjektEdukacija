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

import com.citymanager.app.model.Saving;
import com.citymanager.app.service.ISavingService;

@RestController
public class SavingController {
    private ISavingService savingService;

    public SavingController(ISavingService ss) {
        super();
        this.savingService = ss;
    }

    @GetMapping("/savings")
    public List<Saving> findAll() {
        List<Saving> savings = this.savingService.findAll();
        return savings;
    }

    @GetMapping("/savings/{id}")
    public ResponseEntity<?> findbyId(@PathVariable Long id) {
        Saving saving = this.savingService.findbyId(id);
        if (saving == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Saving with Id " + id + " not found.");
        }
        return ResponseEntity.ok(saving);
    }

    @DeleteMapping ("/savings/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        boolean success = this.savingService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Saving with Id " + id + " not found.");
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping ("/savings")
    public ResponseEntity<?> create(@RequestBody Saving saving) {
        Saving newSaving = this.savingService.create(saving);
        return ResponseEntity.ok(newSaving);
    }

    @PutMapping ("savings/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Saving fromData) {
        Saving updatedSaving = this.savingService.update(id, fromData);
        if (updatedSaving == null)  {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Saving with Id " + id + " not found.");
        }
        return ResponseEntity.ok(updatedSaving);
    }
    
}
