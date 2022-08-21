package com.citymanager.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citymanager.app.model.Bank;
import com.citymanager.app.repository.BankRepository;
import com.citymanager.app.service.IBankService;

@Service
public class BankService implements IBankService {
    
    private BankRepository banks;

    public BankService(BankRepository br) {
        super();
        this.banks = br;
    }

    @Override
    public List<Bank> findAll() {
        return this.banks.findAll();
    }

    @Override
    public Bank findById(Long id) {
        try {
            return this.banks.findById(id).get();
        } catch (Exception e) {
            return null; 
        }
    }

    @Override
    public boolean delete(long id) {
        Bank b = this.findById(id);
        try { 
            this.banks.delete(b);
        } catch (Exception e) {
            return false;
        }
        return true;
    }   

    @Override
    public Bank create(Bank b) {
        b = this.banks.save(b);
        return b;
    }


    @Override
    public Bank update(Long id, Bank fromData) {
        Bank oldBank = this.findById(id);

        if (oldBank == null) {
            return null;
        }

        oldBank.setBankName(fromData.getBankName());
        
        return this.banks.save(oldBank);
    }

}
