package com.citymanager.app.service;

import java.util.List;

import com.citymanager.app.model.Tag;

public interface ITagService {
    Tag findById(long id);
    List<Tag> findAll();
}
