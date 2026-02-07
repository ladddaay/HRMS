package com.aayush.lad.hrms.shared.base_models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;


@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
