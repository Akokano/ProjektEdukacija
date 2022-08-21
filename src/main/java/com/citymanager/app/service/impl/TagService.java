package com.citymanager.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citymanager.app.model.Tag;
import com.citymanager.app.repository.TagRepository;
import com.citymanager.app.service.ITagService;

@Service
public class TagService implements ITagService {

    private TagRepository tags;

    public TagService(TagRepository cr) {
        super();
        this.tags = cr;
    }

    @Override
    public Tag findById(long id) {
        try {
            return tags.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Tag> findAll() {
        return this.tags.findAll();
    }
    
}
