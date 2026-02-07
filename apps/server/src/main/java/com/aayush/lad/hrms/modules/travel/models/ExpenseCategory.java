package com.aayush.lad.hrms.modules.travel.models;

import com.aayush.lad.hrms.shared.base_models.AuditableModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "expense_categories")
@EqualsAndHashCode(callSuper = true)
public class ExpenseCategory extends AuditableModel {

    @Column(nullable = false, unique = true)
    private String name;
}
