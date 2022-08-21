package com.citymanager.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.citymanager.app.model.Tag;
import com.citymanager.app.service.ITagService;

@RestController
public class TagController {
    private ITagService tagService;

    public TagController(ITagService cs) {
        super();
        this.tagService = cs;
    }

    @GetMapping("/tags")
    public List<Tag> findAll() {
        List<Tag> tags = this.tagService.findAll();
        return tags;
    }

    @GetMapping("/tags/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Tag tag = this.tagService.findById(id);
        if (tag == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Tag with id " + id + " not found");
        }
        return ResponseEntity.ok(tag);
    }   
}
