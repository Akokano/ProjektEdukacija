package com.citymanager.app.service;

import com.citymanager.app.model.Region;

import java.util.List;

public interface IRegionService {
    Region findById(long id);
    List<Region> findAll();
    boolean delete(long id);
    Region create(Region region);
    Region update(long id, Region fromData);
    
}
