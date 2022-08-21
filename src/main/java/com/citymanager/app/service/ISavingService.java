package com.citymanager.app.service;

import java.util.List;

import com.citymanager.app.model.Saving;

public interface ISavingService {
    Saving findbyId(long id);
    List<Saving> findAll();
    boolean delete (long id);
    Saving create (Saving saving);
    Saving update (long id, Saving fromData);
}
