package com.aayush.lad.hrms.modules.jobs.models;

import com.aayush.lad.hrms.modules.user.models.User;
import com.aayush.lad.hrms.shared.base_models.BaseModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "job_opening_share_audit")
@EqualsAndHashCode(callSuper = true)
public class JobOpeningShareAudit extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_opening_id", nullable = false)
    private JobOpening jobOpening;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shared_by_id", nullable = false)
    private User sharedBy;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime sharedAt;

    @Column(nullable = false)
    private String sharedTo;
}
