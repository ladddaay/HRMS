package com.aayush.lad.hrms.modules.user.models;

import com.aayush.lad.hrms.shared.base_models.BaseModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "notifications")
@EqualsAndHashCode(callSuper = true)
public class Notification extends BaseModel {

    @Column(nullable = false)
    private String content;

    private Boolean isRead = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
