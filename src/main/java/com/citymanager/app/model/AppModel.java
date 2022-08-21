package com.citymanager.app.model;

import java.time.Instant;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
public class AppModel {

    @CreatedDate
    private Instant createdAt;
}
