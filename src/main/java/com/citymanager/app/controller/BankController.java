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

import com.citymanager.app.model.Bank;
import com.citymanager.app.service.IBankService;


@RestController
public class BankController {
    private IBankService bankService;

    private BankController(IBankService bs){
        super();
        this.bankService = bs;
    }

    @GetMapping("/banks")
    public List<Bank> findAll() {
        List<Bank> banks = this.bankService.findAll();
        return banks;
    }

    @GetMapping ("/banks){Id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Bank bank = this.bankService.findById(id);
        if (bank == null) {
            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Bank with Id " + id + " not found.");
        }
        return ResponseEntity.ok(bank);
    }

    @DeleteMapping ("/banks/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {

        boolean success = this.bankService.delete(id);
        if (!success) {
            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Bank with Id " + id + " not found.");
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/banks")
    public ResponseEntity<?> create(@RequestBody Bank bank) {
        Bank newBank = this.bankService.create(bank);
        return ResponseEntity.ok(newBank);
    }

    @PutMapping("/banks/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,  @RequestBody Bank fromData) {
        Bank updatedBank = this.bankService.update(id, fromData);
        if (updatedBank == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Bank with Id " + id + " not found.");
        }
        return ResponseEntity.ok(updatedBank);
    }
    
}
