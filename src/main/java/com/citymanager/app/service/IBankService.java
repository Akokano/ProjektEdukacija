package com.citymanager.app.service;

import java.util.List;

import com.citymanager.app.model.Bank;

public interface IBankService {
    Bank findById(Long id);
    List<Bank> findAll();
    boolean delete (long id);
    Bank create (Bank bank);
    Bank update (Long id, Bank fromData);
}
