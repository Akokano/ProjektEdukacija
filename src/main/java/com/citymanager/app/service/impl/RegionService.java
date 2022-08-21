package com.citymanager.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citymanager.app.model.Region;
import com.citymanager.app.repository.RegionRepository;
import com.citymanager.app.service.IRegionService;

@Service
public class RegionService implements IRegionService {

    private RegionRepository regions;

    public RegionService(RegionRepository rr) {
        super();
        this.regions = rr;
    }

    @Override
    public List<Region> findAll(){
        return this.regions.findAll();
    }

    @Override
    public Region findById(long id) {
        try{
            return this.regions.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean delete(long id) {
        Region r = this.findById(id);
        try{
            this.regions.delete(r);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Region create(Region r) {
        r = this.regions.save(r);
        return r;
    }

    @Override
    public Region update(long id, Region fromData) {
        Region oldRegion = this.findById(id);

        if(oldRegion == null) {
            return null;
        }

        oldRegion.setRegionName(fromData.getRegionName());

        return this.regions.save(oldRegion);
        
    }
}