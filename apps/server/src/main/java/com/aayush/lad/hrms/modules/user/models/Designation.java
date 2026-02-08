package com.aayush.lad.hrms.modules.user.models;

import com.aayush.lad.hrms.modules.user.dtos.designation.write.UpdateDesignationRequest;
import com.aayush.lad.hrms.shared.base_models.AuditableModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "designations")
@EqualsAndHashCode(callSuper = true)
public class Designation extends AuditableModel {

    @Column(nullable = false, unique = true)
    private String name;


    public void update(UpdateDesignationRequest request) {
        this.name = request.getName();
    }
}
